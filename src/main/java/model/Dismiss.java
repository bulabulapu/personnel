package model;

/**
 * 离职员工信息类
 */
public class Dismiss {
	/* 离职信息id */
	private int dimId;
	/* 员工id */
	private int staffId;
	/* 离职日期 */
	private String dimDate;
	/* 离职类型 */
	private String dimType;
	/* 离职去向 */
	private String dimDirection;
	/* 离职备注 */
	private String dimRemark;

	public int getDimId() {
		return dimId;
	}

	public void setDimId(int dimId) {
		this.dimId = dimId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getDimDate() {
		return dimDate;
	}

	public void setDimDate(String dimDate) {
		this.dimDate = dimDate;
	}

	public String getDimType() {
		return dimType;
	}

	public void setDimType(String dimType) {
		this.dimType = dimType;
	}

	public String getDimDirection() {
		return dimDirection;
	}

	public void setDimDirection(String dimDirection) {
		this.dimDirection = dimDirection;
	}

	public String getDimRemark() {
		return dimRemark;
	}

	public void setDimRemark(String dimRemark) {
		this.dimRemark = dimRemark;
	}

	@Override
	public String toString() {
		return "Dimission [dimId=" + dimId + ", staffId=" + staffId + ", dimDate=" + dimDate + ", dimType=" + dimType
				+ ", dimDirection=" + dimDirection + ", dimRemark=" + dimRemark + "]";
	}

}
