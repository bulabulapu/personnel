package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import model.Department;
import service.DepartmentService;

@Controller
public class control {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "department333")
	@ResponseBody
	public void result555(int a) {
		PageInfo<Department> pageInfo = departmentService.queryAllDepartment();
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());

	}

}
