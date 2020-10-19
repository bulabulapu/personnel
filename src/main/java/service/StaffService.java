package service;

import com.github.pagehelper.PageInfo;
import model.Staff;

/**
 * 员工服务接口
 */
public interface StaffService {
	
	
	public PageInfo<Staff> queryAllStaff(int page);

    /**
     * 新增员工
     *
     * @param staff 员工信息
     * @return 成功标识
     */
    public boolean addStaff(Staff staff);

    /**
     * 更改员工信息
     *
     * @param staff 员工信息
     * @return 成功标识
     */
    public boolean alterStaff(Staff staff);

    /**
     * 删除员工
     *
     * @param id 员工id
     * @return 成功标识
     */
    public boolean deleteStaff(int id);

    /**
     * 通过id获取员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    public Staff getStaff(int id);

    /**
     * 通过名字获取员工信息
     *
     * @param name 员工名字
     * @param page 页码
     * @return 员工信息分页list
     */
    public PageInfo<Staff> getStaff(String name, int page);

    /**
     * 检查id是否合法
     *
     * @param id
     * @return 状态
     */
    public boolean checkId(int id);
}
