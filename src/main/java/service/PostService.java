package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import model.Post;

public interface PostService {

	/**
	 * 获取所有岗位信息
	 * 
	 * @param page 当前页数
	 * @return 岗位分页list
	 */
	public PageInfo<Post> queryAllPost(int page);

	/**
	 * 获取某个岗位信息
	 * 
	 * @param id 岗位id
	 * @return 岗位信息
	 */
	public Post getPost(int id);

	/**
	 * 新建岗位
	 * 
	 * @param id 新岗位
	 * @return 成功标识
	 */
	public boolean addPost(int poId, int deId, String poName);

	/**
	 * 更改岗位信息
	 * 
	 * @param id 更改后岗位
	 * @return 成功标识
	 */
	public boolean alterPost(Post post);

	/**
	 * 删除岗位
	 * 
	 * @param id 岗位id
	 * @return 成功标识
	 */
	public boolean deletePost(int id);

	/**
	 * 查询某部门下的岗位
	 * 
	 * @param id 部门id
	 * @return 岗位list
	 */
	public List<Post> queryPostByDepartId(int id);
}
