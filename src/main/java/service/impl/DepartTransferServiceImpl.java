package service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DepartTransferDao;
import dao.PostDao;
import dao.StaffDao;
import model.DepartTransfer;
import model.Staff;

import org.springframework.stereotype.Service;
import service.DepartTransferService;
import util.PageUtils;

/**
 * 部门调动服务接口实现类
 */
@Service("departTransferService")
public class DepartTransferServiceImpl implements DepartTransferService {

    @Autowired
    private DepartTransferDao departTransferDao;
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private PostDao postDao;

    @Override
    public PageInfo<DepartTransfer> queryDepartmentAlter(int id, int page) {
        PageHelper.startPage(page, PageUtils.PAGESIZE);
        return new PageInfo<>(departTransferDao.queryTransferByStaffId(id));
    }

    @Override
    public boolean alterStaffDepartment(DepartTransfer departTransfer,int poId) {
    	Staff staff = staffDao.getStaffById(departTransfer.getStaffId());
    	staff.setPost(postDao.getPostById(poId));
        staffDao.alterStaff(staff);
        departTransfer.setDeTrId(0);
        int before = departTransferDao.countTransfer();
        departTransferDao.addTransfer(departTransfer);
        return before + 1 == departTransferDao.countTransfer();
    }

    @Override
    public List<DepartTransfer> queryAllTransfers() {
        return departTransferDao.queryAll();
    }

}
