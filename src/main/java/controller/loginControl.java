package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Admin;
import service.AdminService;
import service.DepartmentService;

@Controller
public class loginControl {

	@Autowired
	private AdminService adminService;

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/login")
	public void login(Admin admin, HttpServletResponse resp) {
		// System.out.println(admin.getAdminId());
		// Admin admin2 = adminService.getAdmin(admin.getAdminId());
		// System.out.println(admin2);
		Admin a = new Admin();
		a.setAdminId("000000");
		a.setAdminPWord("123456");
		String result = adminService.identifyAdmin(a);
		if (result.isEmpty()) {
			System.out.println("empty");
		} else {
			System.out.println(result);
		}
	}

	@RequestMapping(value = "/department")
	public void departmentTest(HttpServletResponse resp) {
		System.out.println(departmentService.getAllDepartment());
		System.out.println("ccczxczxczcxz");
	}
}
