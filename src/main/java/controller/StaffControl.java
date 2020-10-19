package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import model.Staff;
import service.StaffService;
import util.PageUtils;
import util.ResponseUtil;

@Controller
@RequestMapping("/staff")
public class StaffControl {

	@Autowired
	private StaffService staffService;

	@RequestMapping("/all")
	@ResponseBody
	public PageInfo<Staff> getAllStaff(int page) {
		PageInfo<Staff> pageInfo = staffService.queryAllStaff(page);
		return pageInfo;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Staff getStaff(int staffId) {
		Staff staff = staffService.getStaff(staffId);
		return staff;
	}

	@RequestMapping("/del")
	public void delStaff(int staffId, HttpServletResponse resp) {
		boolean b = staffService.deleteStaff(staffId);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("add")
	public void addStaff(Staff staff, HttpServletResponse resp) {
		System.out.println(staff);
		boolean b = staffService.addStaff(staff);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("alter")
	public void alterStaff(Staff staff, HttpServletResponse resp) {
		System.out.println(staff);
		boolean b = staffService.alterStaff(staff);
		ResponseUtil.response(resp, b);
	}

	@RequestMapping("search")
	@ResponseBody
	public PageInfo<Staff> search(String key, String type, int page) {
		System.out.println(key + " " + type + " " + page);
		PageInfo<Staff> pageInfo = null;
		if (type.equals("员工号")) {
			pageInfo = searchId(Integer.parseInt(key));
		} else if (type.equals("all")) {
			pageInfo = staffService.queryAllStaff(page);
		} else {
			pageInfo = searchName(key, page);
		}
		return pageInfo;

	}

	private PageInfo<Staff> searchId(int staffId) {
		PageInfo<Staff> pageInfo = new PageInfo<>();
		Staff staff = staffService.getStaff(staffId);
		List<Staff> list = new ArrayList<>();
		list.add(staff);
		pageInfo.setList(list);
		pageInfo.setPageNum(1);
		pageInfo.setTotal(staff == null ? 0 : 1);
		pageInfo.setPages(1);
		pageInfo.setPageSize(PageUtils.PAGESIZE);
		return pageInfo;

	}

	private PageInfo<Staff> searchName(String name, int page) {
		PageInfo<Staff> pageInfo = staffService.getStaff(name, page);
		return pageInfo;
	}
}
