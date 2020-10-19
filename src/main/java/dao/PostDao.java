package dao;

import model.Department;
import model.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 岗位Dao
 */
@Repository("postDao")
@Mapper
public interface PostDao {

	/**
	 * 获取所有岗位信息
	 * 
	 * @return 岗位List
	 */
	@Results(id = "getpost", value = {
			@Result(column = "deId", property = "department", javaType = Department.class, one = @One(select = "dao.DepartmentDao.getDepartmentById")) })
	@Select("select * from post,department where post.deId=department.deId")
	public List<Post> queryAllPost();

	/**
	 * 新建岗位
	 * 
	 * @param post 岗位信息
	 */
	@Insert("insert into post values(#{poId},#{deId},#{poName})")
	public void addPost(@Param("poId") int poId, @Param("deId") int deId, @Param("poName") String poName);

	/**
	 * 更改岗位信息
	 * 
	 * @param post 岗位信息
	 */
	@Update("update post set poName = #{poName} where poId = #{poId}")
	public void alterPost(Post post);

	/**
	 * 删除岗位
	 * 
	 * @param id 岗位编号
	 */
	@Delete("delete from post where poId = #{id}")
	public void deletePost(int id);

	/**
	 * 获取岗位信息
	 * 
	 * @param id 岗位编号
	 * @return 岗位
	 */
	@ResultMap("getpost")
	@Select("select * from post where poId = #{id}")
	public Post getPostById(int id);

	/**
	 * 查询某部门下的岗位
	 * 
	 * @param id 部门id
	 * @return 岗位list
	 */
	@ResultMap("getpost")
	@Select("select * from post where deId = #{id}")
	public List<Post> queryPostByDepartId(int id);

}
