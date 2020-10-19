package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ReportService;
import util.ResponseUtil;

@Controller
@RequestMapping("/report")
public class ReportControl {

	@Autowired
	private ReportService reportService;

	@RequestMapping("/download")
	public void download(int type, String start, String end, HttpServletResponse resp) {
		switch (type) {
		case 1:
			reportService.getNewStaffReport(start, end, resp);
			break;
		case 2:
			reportService.getDismissStaffReport(start, end, resp);
			break;
		case 3:
			reportService.getDepartTransferReport(start, end, resp);
			break;
		case 4:
			reportService.getPostTransferReport(start, end, resp);
			break;

		default:
			String message = "<script>alert(\"下载错误\");javascript:self.location=document.referrer;</script>";
			ResponseUtil.response(resp, message);
			break;
		}
	}

	@RequestMapping("/monthdownload")
	public void download2(String date, HttpServletResponse resp) {
		String[] s = date.split("-");
		int year = Integer.parseInt(s[0]);
		int month = Integer.parseInt(s[1]);
		System.out.println(year + " " + month);
		reportService.getStaffReport(year,month,resp);
	}

}
