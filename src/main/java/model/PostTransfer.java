package model;

/**
 * 岗位调动记录
 */
public class PostTransfer {
    /* 记录编号 */
    private int id;
    /* 员工编号 */
    private int staffId;
    /* 调后岗位 */
    private String newPost;
    /* 原岗位 */
    private String oldPost;
    /* 岗位调转类型 */
    private String poType;
    /* 岗位调转原因 */
    private String poReson;
    /* 岗位调转备注 */
    private String poRemark;
    /* 岗位调转日期 */
    private String poDate;

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

    public String getNewPost() {
        return newPost;
    }

    public void setNewPost(String newPost) {
        this.newPost = newPost;
    }

    public String getOldPost() {
        return oldPost;
    }

    public void setOldPost(String oldPost) {
        this.oldPost = oldPost;
    }

    public String getPoType() {
        return poType;
    }

    public void setPoType(String poType) {
        this.poType = poType;
    }

    public String getPoReson() {
        return poReson;
    }

    public void setPoReson(String poReson) {
        this.poReson = poReson;
    }

    public String getPoRemark() {
        return poRemark;
    }

    public void setPoRemark(String poRemark) {
        this.poRemark = poRemark;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    @Override
    public String toString() {
        return "PostTransfer [id=" + id + ", newPost=" + newPost + ", oldPost=" + oldPost + ", poDate=" + poDate
                + ", poRemark=" + poRemark + ", poReson=" + poReson + ", poType=" + poType + ", staffId=" + staffId
                + "]";
    }
}
