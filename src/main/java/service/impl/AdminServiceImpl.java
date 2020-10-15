package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDao;
import model.Admin;
import service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin identifyAdmin(Admin admin) {
		if (admin != null) {
			Admin a = adminDao.getAdmin(admin.getAdminId());
			if (a != null) {
				if (a.getAdminPWord().equals(admin.getAdminPWord())) {
					return a;
				}
			}
		}
		return null;
	}

}
