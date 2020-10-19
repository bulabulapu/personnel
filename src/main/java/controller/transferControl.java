package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.DepartTransfer;
import model.PostTransfer;
import service.DepartTransferService;
import service.PostTransferService;
import util.ResponseUtil;

@Controller
@RequestMapping("/transfer")
public class transferControl {

	@Autowired
	private DepartTransferService departTransferService;
	@Autowired
	private PostTransferService postTransferService;

	@RequestMapping("/add")
	public String addTransfer(int type) {
		System.out.println(type);
		if (type == 0) {
			return "forward:department";
		} else {
			return "forward:post";
		}

	}

	@RequestMapping("/department")
	public void trandferDe(DepartTransfer departTransfer,int poId, HttpServletResponse resp) {
		System.out.println(departTransfer+" "+poId);
		boolean b = departTransferService.alterStaffDepartment(departTransfer,poId);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("/post")
	public void transferPo(PostTransfer postTransfer,int poId, HttpServletResponse resp) {
		System.out.println(postTransfer+" "+poId);
		boolean b = postTransferService.addPostTransfer(postTransfer,poId);
		ResponseUtil.response(resp, b);
	}

}
