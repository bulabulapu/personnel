package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Dismiss;
import service.DismissService;
import util.ResponseUtil;

@Controller
@RequestMapping("/dimission")
public class DimissionControl {

	@Autowired
	private DismissService dismissService;

	@RequestMapping("/add")
	public void addDimission(Dismiss dismiss, HttpServletResponse resp) {
		System.out.println(dismiss);
		boolean b = dismissService.insetDismiss(dismiss);
		String message = b ? "<script>alert(\"操作成功\");javascript:self.location=document.referrer;</script>"
				: "<script>alert(\"操作失败\");javascript:history.go(-2);</script>";
		ResponseUtil.response(resp, message);
	}

}
