package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import model.PostTransfer;

/**
 * 岗位调动服务接口
 */
public interface PostTransferService {
    /**
     * 查询某员工的岗位调动信息
     *
     * @param id   员工id
     * @param page 页码
     * @return 记录分页list
     */
    public PageInfo<PostTransfer> queryPostTransfer(int id, int page);

    /**
     * 添加岗位调动信息
     *
     * @param postTransfer 记录信息
     * @param poId 新岗位id
     * @return 状态
     */
    public boolean addPostTransfer(PostTransfer postTransfer,int poId);

    /**
     * 查询所有岗位调动记录
     * @return 记录list
     */
    public List<PostTransfer> queryAllTransfers();

}
