package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.PostDao;
import model.Post;
import service.PostService;
import util.PageUtils;

/**
 * 岗位服务接口实现类
 */
@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Override
	public PageInfo<Post> queryAllPost(int page) {
		PageHelper.startPage(page, PageUtils.PAGESIZE);
		return new PageInfo<>(postDao.queryAllPost());
	}

	@Override
	public Post getPost(int id) {
		return postDao.getPostById(id);
	}

	@Override
	public boolean addPost(int poId, int deId, String poName) {
		try {
			postDao.addPost(poId, deId, poName);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterPost(Post post) {
		try {
			postDao.alterPost(post);
			return postDao.getPostById(post.getPoId()) != null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deletePost(int id) {
		try {
			postDao.deletePost(id);
			return postDao.getPostById(id) == null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Post> queryPostByDepartId(int id) {
		return postDao.queryPostByDepartId(id);
	}

}
