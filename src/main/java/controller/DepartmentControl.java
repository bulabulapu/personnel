package controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import model.Department;
import service.DepartmentService;
import util.ResponseUtil;

@Controller
@RequestMapping("/department")
public class DepartmentControl {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping("/all")
	@ResponseBody
	public PageInfo<Department> getAllDepartment(int page) {
		PageInfo<Department> pageInfo = departmentService.queryAllDepartment(page);
		return pageInfo;
	}

	@RequestMapping("/alldepart")
	@ResponseBody
	public List<Department> allDepartmentNoPage() {
		return departmentService.queryAllDepartmentNoPage();
	}

	@RequestMapping("/get")
	@ResponseBody
	public Department getDepartment(int deId) {
		Department department = departmentService.getDepartment(deId);
		return department;
	}

	@RequestMapping("/add")
	public void addDepartment(Department department, HttpServletResponse resp) {
		int id = department.getDeId();
		String name = department.getDeName();
		boolean b = departmentService.addDepartment(id, name);
		String message = b ? "<script>alert(\"添加成功\");javascript:self.location=document.referrer;</script>"
				: "<script>alert(\"添加失败\");javascript:history.go(-1);</script>";
		ResponseUtil.response(resp, message);
	}

	@RequestMapping("/del")
	public void delDepartment(int deId, HttpServletResponse resp) {
		boolean b = departmentService.deleteDepartment(deId);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("/alter")
	public void alterDepartment(Department department, HttpServletResponse resp) {
		int id = department.getDeId();
		String newName = department.getDeName();
		System.out.println(id + " " + newName);
		boolean b = departmentService.alterDepartment(id, newName);
		String message = b ? "<script>alert(\"修改成功\");javascript:self.location=document.referrer;</script>"
				: "<script>alert(\"修改失败\");javascript:history.go(-1);</script>";
		ResponseUtil.response(resp, message);
	}

}
