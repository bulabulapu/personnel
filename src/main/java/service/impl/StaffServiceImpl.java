package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.StaffDao;
import model.Post;
import model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StaffService;
import util.PageUtils;

import java.util.List;

/**
 * 员工服务接口实现类
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;

	@Override
	public boolean addStaff(Staff staff) {
		try {
			if (staff.getGraduationDate().equals("")) {
				staff.setGraduationDate(null);
			}
			staffDao.addStaff(staff);
			return staffDao.getStaffById(staff.getStaffId()) != null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean alterStaff(Staff staff) {
		if (staff.getGraduationDate().equals("")) {
			staff.setGraduationDate(null);
		}
		try {
			staffDao.alterStaff(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteStaff(int id) {
		try {
			staffDao.deleteStaff(id);
			return staffDao.getStaffById(id) == null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Staff getStaff(int id) {
		return staffDao.getStaffById(id);
	}

	@Override
	public PageInfo<Staff> getStaff(String name, int page) {
		PageHelper.startPage(page, PageUtils.PAGESIZE);
		List<Staff> list = staffDao.getStaffByName(name);
		Post temp;
		for (Staff l : list) {
			// temp = postDao.getPostById(l.getPoId());
			// l.setPoName(temp.getPoName());
			// l.setDeName(departmentDao.getDepartmentById(temp.getDeId()).getDeName());
		}
		return new PageInfo<>(list);
	}

	@Override
	public boolean checkId(int id) {
		return staffDao.getStaffById(id) == null;
	}

	@Override
	public PageInfo<Staff> queryAllStaff(int page) {
		PageHelper.startPage(page, PageUtils.PAGESIZE);
		return new PageInfo<>(staffDao.queryAllStaff());
	}

}
