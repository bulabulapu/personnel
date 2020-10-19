package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import model.DepartTransfer;

/**
 * 部门调动服务接口
 */
public interface DepartTransferService {

    /**
     * 查询某员工的部门调动记录
     *
     * @param id 员工id
     * @param  page 页码
     * @return 记录分页list
     */
    public PageInfo<DepartTransfer> queryDepartmentAlter(int id, int page);

    /**
     * 添加员工部门调动记录
     *
     * @param departTransfer 记录信息
     * @param poId 新岗位id
     * @return 状态
     */
    public boolean alterStaffDepartment(DepartTransfer departTransfer, int poId);

    /**
     * 查询所有调动记录
     * @return 记录list
     */
    public List<DepartTransfer> queryAllTransfers();
}