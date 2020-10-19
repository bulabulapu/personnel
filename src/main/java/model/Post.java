package model;

/**
 * 岗位类
 */
public class Post {
	/* 岗位编号 */
	private int poId;
	/* 岗位名称 */
	private String poName;
	/* 部门编号 */
	private Department department;
	
	public Post() {
		
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Post [poId=" + poId + ", poName=" + poName + ", department=" + department + "]";
	}

}
