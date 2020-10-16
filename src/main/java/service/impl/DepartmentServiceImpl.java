package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.DepartmentDao;
import model.Department;
import model.Staff;
import service.DepartmentService;

/**
 * 部门服务接口实现类
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public PageInfo<Department> queryAllDepartment() {
    	PageHelper.startPage(1, 2);
    	List<Department> list =  departmentDao.queryAllDepartment();
    	PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Staff> queryDepartmentStaff(int id) {
        return departmentDao.queryDepartmentStaff(id);
    }

    @Override
    public boolean addDepartment(int id, String name) {
        Department temp = new Department();
        temp.setDeId(id);
        temp.setDeName(name);
        departmentDao.addDepartment(temp);
        if (departmentDao.getDepartmentById(id) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean alterDepartment(int id, String newName) {
        Department temp = new Department();
        temp.setDeId(id);
        temp.setDeName(newName);
        departmentDao.alterDepartment(temp);
        if (newName.equals(departmentDao.getDepartmentById(id).getDeName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(int id) {
        departmentDao.deleteDepartment(id);
        if (departmentDao.getDepartmentById(id) != null) {
            return false;
        }
        return true;
    }
}
