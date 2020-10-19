package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import model.Department;

/**
 * 部门服务接口
 */
public interface DepartmentService {

    /**
     * 获取所有部门信息
     * 
     * @param page 当前页数
     * @return 部门分页list
     */
    public PageInfo<Department> queryAllDepartment(int page);
    
    /**
     * 获取所有部门信息
     * 
     * @return 部门list
     */
    public List<Department> queryAllDepartmentNoPage();
    

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

    /**
     * 检查id是否合法
     *
     * @param id
     * @return 状态
     */
    public boolean checkId(int id);

    /**
     * 获取某个部门信息
     * @param id 部门id
     * @return 岗位信息
     */
    public Department getDepartment(int id);
}
