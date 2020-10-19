package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.DepartmentDao;
import model.Department;
import service.DepartmentService;
import util.PageUtils;

/**
 * 部门服务接口实现类
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public PageInfo<Department> queryAllDepartment(int page) {
        PageHelper.startPage(page, PageUtils.PAGESIZE);
        return new PageInfo<>(departmentDao.queryAllDepartment());
    }

    @Override
    public boolean addDepartment(int id, String name) {
        try {
            Department temp = new Department();
            temp.setDeId(id);
            temp.setDeName(name);
            departmentDao.addDepartment(temp);
            return departmentDao.getDepartmentById(id) != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean alterDepartment(int id, String newName) {
        Department temp = new Department();
        temp.setDeId(id);
        temp.setDeName(newName);
        departmentDao.alterDepartment(temp);
        return newName.equals(departmentDao.getDepartmentById(id).getDeName());
    }

    @Override
    public boolean deleteDepartment(int id) {
        try {
            departmentDao.deleteDepartment(id);
            return departmentDao.getDepartmentById(id) == null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean checkId(int id) {
        return departmentDao.getDepartmentById(id) == null;
    }

    @Override
    public Department getDepartment(int id) {
        return departmentDao.getDepartmentById(id);
    }

	@Override
	public List<Department> queryAllDepartmentNoPage() {
		return departmentDao.queryAllDepartment();
	}
}
