
package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.PostDao;
import dao.PostTransferDao;
import dao.StaffDao;
import model.PostTransfer;
import model.Staff;
import service.PostTransferService;
import util.PageUtils;

/**
 * 岗位调动服务接口实现类
 */
@Service("postTransferService")
public class PostTransferServiceImpl implements PostTransferService {

    @Autowired
    private PostTransferDao postTransferDao;
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private PostDao postDao;

    @Override
    public PageInfo<PostTransfer> queryPostTransfer(int id, int page) {
        PageHelper.startPage(page, PageUtils.PAGESIZE);
        return new PageInfo<>(postTransferDao.queryPostTransferStaff(id));
    }

    @Override
    public boolean addPostTransfer(PostTransfer postTransfer,int poId) {
        Staff staff = staffDao.getStaffById(postTransfer.getStaffId());
        staff.setPost(postDao.getPostById(poId));
        staffDao.alterStaff(staff);
        postTransfer.setPoTrId(0);
        int before = postTransferDao.countTransfer();
        postTransferDao.addPostTransfer(postTransfer);
        return before + 1 == postTransferDao.countTransfer();
    }

    @Override
    public List<PostTransfer> queryAllTransfers() {
        return postTransferDao.queryAll();
    }

}
