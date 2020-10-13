package model;

/**
 * 部门调动记录类
 */
public class DepartTransfer {
    /* 记录编号 */
    private int id;
    /* 员工编号 */
    private int staffId;
    /* 调后部门 */
    private String newDepart;
    /* 原部门 */
    private String oldDepart;
    /* 部门调转类型 */
    private String deType;
    /* 部门调转原因 */
    private String deReson;
    /* 部门调转备注 */
    private String deRemark;
    /* 部门调转日期 */
    private String deDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getNewDepart() {
        return newDepart;
    }

    public void setNewDepart(String newDepart) {
        this.newDepart = newDepart;
    }

    public String getOldDepart() {
        return oldDepart;
    }

    public void setOldDepart(String oldDepart) {
        this.oldDepart = oldDepart;
    }

    public String getDeType() {
        return deType;
    }

    public void setDeType(String deType) {
        this.deType = deType;
    }

    public String getDeReson() {
        return deReson;
    }

    public void setDeReson(String deReson) {
        this.deReson = deReson;
    }

    public String getDeRemark() {
        return deRemark;
    }

    public void setDeRemark(String deRemark) {
        this.deRemark = deRemark;
    }

    public String getDeDate() {
        return deDate;
    }

    public void setDeDate(String deDate) {
        this.deDate = deDate;
    }

    @Override
    public String toString() {
        return "DepartTransfer [deDate=" + deDate + ", deRemark=" + deRemark + ", deReson=" + deReson + ", deType="
                + deType + ", id=" + id + ", newDepart=" + newDepart + ", oldDepart=" + oldDepart + ", staffId="
                + staffId + "]";
    }
}
