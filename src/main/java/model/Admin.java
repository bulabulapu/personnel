package model;

/**
 * 管理员类
 */
public class Admin {
    /* 管理员id */
    private int id;
    /* 管理员账户名称 */
    private String adminName;
    /* 管理员账户密码 */
    private String adminPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin [adminName=" + adminName + ", adminPassword=" + adminPassword + ", id=" + id + "]";
    }
}
