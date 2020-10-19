package model;

/**
 * 部门
 */
public class Department {
	/* 部门id */
	private int deId;
	/* 部门名称 */
	private String deName;
	
	public Department() {
		
	}

	public int getDeId() {
		return deId;
	}

	public void setDeId(int deId) {
		this.deId = deId;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}

	@Override
	public String toString() {
		return "Department [deId=" + deId + ", deName=" + deName + "]";
	}

}
