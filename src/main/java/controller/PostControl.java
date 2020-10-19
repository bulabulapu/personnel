package controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import model.Post;
import service.PostService;
import util.ResponseUtil;

@Controller
@RequestMapping("/post")
public class PostControl {

	@Autowired
	private PostService postService;

	@RequestMapping("/all")
	@ResponseBody
	public PageInfo<Post> getAllPost(int page) {
		PageInfo<Post> pageInfo = postService.queryAllPost(page);
		return pageInfo;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Post getPost(int poId) {
		Post post = postService.getPost(poId);
		return post;
	}

	@RequestMapping("del")
	public void delPost(int poId, HttpServletResponse resp) {
		boolean b = postService.deletePost(poId);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("add")
	public void addPost(int poId, int deId, String poName, HttpServletResponse resp) {
		System.out.println(poId + " " + deId + " " + poName);
		boolean b = postService.addPost(poId, deId, poName);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("alter")
	public void alterPost(Post post, HttpServletResponse resp) {
		System.out.println(post);
		boolean b = postService.alterPost(post);
		String message = b ? "<script>alert(\"修改成功\");javascript:self.location=document.referrer;</script>"
				: "<script>alert(\"修改失败\");javascript:history.go(-1);</script>";
		ResponseUtil.response(resp, message);
	}
	
	@RequestMapping("/postbydeid")
	@ResponseBody
	public List<Post> allPostbyDeId(int deId){
		List<Post> list =  postService.queryPostByDepartId(deId);
		return list;
	}
}
