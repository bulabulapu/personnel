package service;

import javax.servlet.http.HttpServletResponse;

/**
 * 报表服务接口
 */
public interface ReportService {
	
	/**
	 * 某段时间内的新聘员工报表
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param response 文件输出通道
	 */
	public void getNewStaffReport(String start,String end,HttpServletResponse response);
	
	/**
	 * 某段时间内的离职员工报表
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param response 文件输出通道
	 */
	public void getDismissStaffReport(String start,String end,HttpServletResponse response);
	
	/**
	 * 某段时间内的部门调动报表
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param response 文件输出通道
	 */
	public void getDepartTransferReport(String start,String end,HttpServletResponse response);
	
	/**
	 * 某段时间内的岗位调动报表
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param response 文件输出通道
	 */
	public void getPostTransferReport(String start,String end,HttpServletResponse response);
	
	/**
	 * 人事月报
	 * @param response 文件输出通道
	 */
	public void getStaffReport(int year,int month,HttpServletResponse response);
}
