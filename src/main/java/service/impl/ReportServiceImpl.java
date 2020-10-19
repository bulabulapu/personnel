package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DepartTransferDao;
import dao.DepartmentDao;
import dao.DismissDao;
import dao.PostTransferDao;
import dao.StaffDao;
import model.DepartTransfer;
import model.Department;
import model.Dismiss;
import model.PostTransfer;
import model.Staff;
import service.ReportService;
import util.ExcelUtil;
import util.TimeUtil;

/**
 * 报表服务实现
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private DepartTransferDao departTransferDao;
	@Autowired
	private PostTransferDao postTransferDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private DismissDao dismissDao;

	@Override
	public void getNewStaffReport(String start, String end, HttpServletResponse response) {
		List<Staff> staffList = staffDao.queryNewStaffByTime(start, end);
		List<String[]> list = new ArrayList<>();
		String[] strs = new String[] { "序号", "部门名称", "岗位名称", "姓名", "性别", "入职日期", "学历" };
		Staff tempStaff;
		list.add(strs);
		for (int i = 0; i < staffList.size(); i++) {
			strs = new String[7];
			strs[0] = i + 1 + "";
			tempStaff = staffList.get(i);
			strs[1] = tempStaff.getPost().getDepartment().getDeName();
			strs[2] = tempStaff.getPost().getPoName();
			strs[3] = tempStaff.getStaffName();
			strs[4] = tempStaff.getSex() == 1 ? "男" : "女";
			strs[5] = tempStaff.getInDay();
			strs[6] = tempStaff.getEducation();
			list.add(strs);
		}
		ExcelUtil.writeXLSX("NewStaffReport", list, response);
	}

	@Override
	public void getDismissStaffReport(String start, String end, HttpServletResponse response) {
		List<Dismiss> dismissList = dismissDao.getDismissByTime(start, end);
		List<String[]> list = new ArrayList<>();
		String[] strs = new String[] { "序号", "部门名称", "岗位名称", "姓名", "性别", "离职日期", "离职原因" };
		Staff tempStaff;
		Dismiss tempDismiss;
		list.add(strs);
		for (int i = 0; i < dismissList.size(); i++) {
			strs = new String[7];
			strs[0] = i + 1 + "";
			tempDismiss = dismissList.get(i);
			tempStaff = staffDao.getStaffById(tempDismiss.getStaffId());
			strs[1] = tempStaff.getPost().getDepartment().getDeName();
			strs[2] = tempStaff.getPost().getPoName();
			strs[3] = tempStaff.getStaffName();
			strs[4] = tempStaff.getSex() == 1 ? "男" : "女";
			strs[5] = tempDismiss.getDimDate();
			strs[6] = tempDismiss.getDimRemark();
			list.add(strs);
		}
		ExcelUtil.writeXLSX("DismissStaffReport", list, response);
	}

	@Override
	public void getDepartTransferReport(String start, String end, HttpServletResponse response) {
		List<DepartTransfer> departTransferList = departTransferDao.getDepartTransferByTime(start, end);
		List<String[]> list = new ArrayList<>();
		String[] strs = new String[] { "序号", "原部门名称", "新部门名称", "姓名", "性别", "调动日期", "调动原因" };
		Staff tempStaff;
		DepartTransfer tempDepartTransfer;
		list.add(strs);
		for (int i = 0; i < departTransferList.size(); i++) {
			strs = new String[7];
			strs[0] = i + 1 + "";
			tempDepartTransfer = departTransferList.get(i);
			tempStaff = staffDao.getStaffById(tempDepartTransfer.getStaffId());
			strs[1] = tempDepartTransfer.getOldDepart();
			strs[2] = tempDepartTransfer.getNewDepart();
			strs[3] = tempStaff.getStaffName();
			strs[4] = tempStaff.getSex() == 1 ? "男" : "女";
			strs[5] = tempDepartTransfer.getDeDate();
			strs[6] = tempDepartTransfer.getDeReson();
			list.add(strs);
		}
		ExcelUtil.writeXLSX("DepartmentTransferReport", list, response);
	}

	@Override
	public void getPostTransferReport(String start, String end, HttpServletResponse response) {
		List<PostTransfer> postTransferList = postTransferDao.getPostTransferByTime(start, end);
		List<String[]> list = new ArrayList<>();
		String[] strs = new String[] { "序号", "原岗位名称", "新岗位名称", "姓名", "性别", "调动日期", "调动原因" };
		Staff tempStaff;
		PostTransfer tempPostTransfer;
		list.add(strs);
		for (int i = 0; i < postTransferList.size(); i++) {
			strs = new String[7];
			strs[0] = i + 1 + "";
			tempPostTransfer = postTransferList.get(i);
			tempStaff = staffDao.getStaffById(tempPostTransfer.getStaffId());
			strs[1] = tempPostTransfer.getOldPost();
			strs[2] = tempPostTransfer.getNewPost();
			strs[3] = tempStaff.getStaffName();
			strs[4] = tempStaff.getSex() == 1 ? "男" : "女";
			strs[5] = tempPostTransfer.getPoDate();
			strs[6] = tempPostTransfer.getPoReson();
			list.add(strs);
		}
		ExcelUtil.writeXLSX("PostTransferReport", list, response);
	}

	@Override
	public void getStaffReport(int year, int month, HttpServletResponse response) {
		List<String[]> list = new ArrayList<>();
		String[] strs = new String[] { "部门名称", "月初人数", "月末人数", "本月新入职", "本月离职", "本月调入", "本月调出" };
		List<Department> departmentList = departmentDao.queryAllDepartment();
		String nowTime = TimeUtil.getNowTime();
		String[] targetTime = TimeUtil.getMonthStartAndEnd(year, month);
		list.add(strs);
		int nowStaffCount = 0; // 当前部门人数
		int targetEndStaffCount = 0; // 目标时间月末部门人数
		int targetStartStaffCount = 0; // 目标时间月初部门人数
		int departmentId = 0; // 部门id
		int newStaffCount = 0; // 某段时间内的部门新入职人数
		int dismissStaffCount = 0; // 某段时间内的部门离职人数
		int inStaffCount = 0; // 某段时间内的部门调入人数
		int outStaffCount = 0; // 某段时间内的部门调出人数
		for (Department department : departmentList) {
			strs = new String[7];
			strs[0] = department.getDeName();
			departmentId = department.getDeId();
			nowStaffCount = staffDao.countDepartStaff(departmentId);
			// 目标时间到当前时间内的人员变动
			newStaffCount = staffDao.countInStaffByDepartAndTime(targetTime[1], nowTime, departmentId);
			dismissStaffCount = dismissDao.countDismissStaffByDepartAndTime(targetTime[1], nowTime, departmentId);
			inStaffCount = departTransferDao.countInByDepartAndTime(targetTime[1], nowTime, departmentId);
			outStaffCount = departTransferDao.countOutByDepartAndTime(targetTime[1], nowTime, departmentId);
			targetEndStaffCount = nowStaffCount - (newStaffCount - dismissStaffCount + inStaffCount - outStaffCount);
			// 目标时间月内人员变动
			newStaffCount = staffDao.countInStaffByDepartAndTime(targetTime[0], targetTime[1], departmentId);
			dismissStaffCount = dismissDao.countDismissStaffByDepartAndTime(targetTime[0], targetTime[1], departmentId);
			inStaffCount = departTransferDao.countInByDepartAndTime(targetTime[0], targetTime[1], departmentId);
			outStaffCount = departTransferDao.countOutByDepartAndTime(targetTime[0], targetTime[1], departmentId);
			targetStartStaffCount = targetEndStaffCount
					- (newStaffCount - dismissStaffCount + inStaffCount - outStaffCount);
			strs[1] = targetStartStaffCount + "";
			strs[2] = targetEndStaffCount + "";
			strs[3] = newStaffCount + "";
			strs[4] = dismissStaffCount + "";
			strs[5] = inStaffCount + "";
			strs[6] = outStaffCount + "";
			list.add(strs);
		}
		ExcelUtil.writeXLSX("StaffReport", list, response);
	}

}
