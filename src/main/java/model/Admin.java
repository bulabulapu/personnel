package model;

/**
 * 管理员类
 */
public class Admin {
	/* 管理员id */
	private int adminId;
	/* 管理员账户名称 */
	private String adminName;
	/* 管理员账户密码 */
	private String adminPWord;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPWord() {
		return adminPWord;
	}

	public void setAdminPWord(String adminPWord) {
		this.adminPWord = adminPWord;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPWord=" + adminPWord + "]";
	}

}
