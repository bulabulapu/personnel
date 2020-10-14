package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDao;
import model.Admin;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao iAdminDao;

	public Admin getAdmin(String adminId) {
		return iAdminDao.getAdmin(adminId);
	}

}
