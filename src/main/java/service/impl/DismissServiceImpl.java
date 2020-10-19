package service.impl;

import java.util.List;

import dao.DismissDao;
import dao.StaffDao;
import model.Dismiss;
import model.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DismissService;

@Service("dismissService")
public class DismissServiceImpl implements DismissService {

    @Autowired
    private DismissDao dismissDao;
    @Autowired
    private StaffDao staffDao;

    @Override
    public boolean insetDismiss(Dismiss dismiss) {
    	Staff staff = staffDao.getStaffById(dismiss.getStaffId());
    	staff.setWorkType("离职员工");
    	staffDao.alterStaff(staff);
        dismiss.setDimId(0);
        int before = dismissDao.countTransfer();
        dismissDao.addRecord(dismiss);
        return before + 1 == dismissDao.countTransfer();
    }

    @Override
    public List<Dismiss> queryDismiss() {
        return dismissDao.queryAll();
    }

}
