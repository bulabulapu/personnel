package dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import model.Post;
import model.Staff;

/**
 * 员工信息Dao
 */
@Repository("staffDao")
@Mapper
public interface StaffDao {

	/**
	 * 获取所有员工信息
	 *
	 * @return 员工List
	 */
	@Results(id = "getstaff", value = {
			@Result(column = "poId", property = "post", javaType = Post.class, one = @One(select = "dao.PostDao.getPostById")) })
	@Select("select * from staff where workType!=\"离职员工\"")
	public List<Staff> queryAllStaff();

	/**
	 * 新建员工信息
	 * 
	 * @param staff 员工信息
	 */
	@Insert("insert into staff values(#{staffId},#{post.poId},#{staffName},#{sex},#{birthday},#{idCard},#{inDay},#{workDay},#{workType},#{source},#{political},#{nation},#{nativePlace},#{phone},#{email},#{height},#{bloodType},#{marital},#{birthPlace},#{huKou},#{education},#{degree},#{college},#{major},#{graduationDate})")
	public void addStaff(Staff staff);

	/**
	 * 更改员工信息
	 * 
	 * @param staff 员工信息
	 */
	@Update("update\n" + "    staff\n" + "set\n" + "    poId = #{post.poId},\n" + "    staffName = #{staffName},\n"
			+ "    sex = #{sex},\n" + "    birthday = #{birthday},\n" + "    idCard = #{idCard},\n"
			+ "    inDay = #{inDay},\n" + "    workDay = #{workDay},\n" + "    workType = #{workType},\n"
			+ "    source = #{source},\n" + "    political = #{political},\n" + "    nation = #{nation},\n"
			+ "    nativePlace = #{nativePlace},\n" + "    phone = #{phone},\n" + "    email = #{email},\n"
			+ "    height = #{height},\n" + "    bloodType = #{bloodType},\n" + "    marital = #{marital},\n"
			+ "    birthPlace = #{birthPlace},\n" + "    huKou = #{huKou},\n" + "    education = #{education},\n"
			+ "    degree = #{degree},\n" + "    college = #{college},\n" + "    major = #{major},\n"
			+ "    graduationDate = #{graduationDate}\n" + "where\n" + "    staffId = #{staffId}")
	public void alterStaff(Staff staff);

	/**
	 * 删除员工
	 * 
	 * @param id 员工id
	 */
	@Delete("delete from staff where staffId = #{id}")
	public void deleteStaff(int id);

	/**
	 * 获取员工数量
	 * 
	 * @return 数量
	 */
	@Select("select count(*) from staff")
	public int countStaff();

	/**
	 * 通过id获取员工信息
	 * 
	 * @param id 员工id
	 * @return 员工信息
	 */
	@ResultMap("getstaff")
	@Select("select * from staff where staffId = #{id}")
	public Staff getStaffById(int id);

	/**
	 * 通过名字获取员工信息
	 * 
	 * @param name 员工名字
	 * @return 员工信息list
	 */
	@ResultMap("getstaff")
	@Select("select * from staff where staffName = #{name}")
	public List<Staff> getStaffByName(String name);

	/**
	 * 查询某段时间内的入职员工
	 * 
	 * @param start 开始日期
	 * @param end   结束日期
	 * @return 员工list
	 */
	@ResultMap("getstaff")
	@Select("select * from staff where inDay >= #{start} and inDay < #{end}")
	public List<Staff> queryNewStaffByTime(@Param("start") String start, @Param("end") String end);

	/**
	 * 查询某个时间段某部门入职人数
	 *
	 * @param start 起时间
	 * @param end   止时间
	 * @param deId  部门id
	 * @return 人数
	 */
	@Select("select count(*) from staff where inDay < #{end} and inDay >= #{start} and poId in (select poId from post where deId = #{deId})")
	public int countInStaffByDepartAndTime(@Param("start") String start, @Param("end") String end,
			@Param("deId") int deId);

	/**
	 * 当前某部门人数
	 *
	 * @param deId 部门id
	 * @return 人数
	 */
	@Select("select count(*) from staff where poId in (select poId from post where deId = #{deId})")
	public int countDepartStaff(@Param("deId") int deId);

}
