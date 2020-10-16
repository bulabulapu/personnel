package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import model.Department;
import model.Staff;

/**
 * 部门服务接口
 */
public interface DepartmentService {
    
    /**
     * 获取所有部门信息
     * @return 部门List
     */
    public PageInfo<Department> queryAllDepartment();

    /**
     * 获取部门员工信息
     * 
     * @param id 部门id
     * @return 员工信息List
     */
    public List<Staff> queryDepartmentStaff(int id);

    /**
     * 新建部门
     * 
     * @param id   新建部门id
     * @param name 新建部门名称
     * @return 完成标志
     */
    public boolean addDepartment(int id, String name);

    /**
     * 更改部门信息
     * 
     * @param id      部门id
     * @param newName 部门新名称
     * @return 完成标志
     */
    public boolean alterDepartment(int id, String newName);

    /**
     * 删除部门
     * 
     * @param id 被删除的部门id
     * @return 完成标志
     */
    public boolean deleteDepartment(int id);
}
