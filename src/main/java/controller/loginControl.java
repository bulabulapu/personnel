package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Admin;
import service.AdminService;

@Controller
public class loginControl {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login")
	public void login(Admin admin, HttpServletResponse resp) {
		System.out.println(admin.getAdminId());
		Admin admin2 = adminService.getAdmin(admin.getAdminId());
		System.out.println(admin2);
	}
}
