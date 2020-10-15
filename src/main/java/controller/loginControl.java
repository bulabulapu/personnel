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
		a.setAdminId("001111");
		a.setAdminPWord("123456");
		// String result = adminService.identifyAdmin(a);
		// if (result.isEmpty()) {
		// 	System.out.println("empty");
		// } else {
			// System.out.println(result);
		// }
	}

	@RequestMapping(value = "/department")
	public void departmentTest(HttpServletResponse resp) {
		System.out.println(departmentService.queryAllDepartment());
		System.out.println("ccczxczxczcxz");
	}

	@RequestMapping(value = "/a")
	public void testA(HttpServletResponse resp) {
		System.out.println(departmentService.queryAllDepartment());
	}

	@RequestMapping(value = "/b")
	public void testB(HttpServletResponse resp) {
		System.out.println(departmentService.addDepartment(3,"划水部"));
	}

	@RequestMapping(value = "/c")
	public void testC(HttpServletResponse resp) {
		System.out.println(departmentService.alterDepartment(3,"水"));
	}

	@RequestMapping(value = "/d")
	public void testD(HttpServletResponse resp) {
		System.out.println(departmentService.deleteDepartment(3));
	}

	@RequestMapping(value = "/e")
	public void testE(HttpServletResponse resp) {
		System.out.println(departmentService.queryDepartmentStaff(0));
	}
}
