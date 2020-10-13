package model;

/**
 * 岗位类
 */
public class Post {
    /*岗位编号 */
    private int id;
    /*部门编号 */
    private int deId;
    /*岗位名称 */
    private String poName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeId() {
        return deId;
    }

    public void setDeId(int deId) {
        this.deId = deId;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    @Override
    public String toString() {
        return "Post [deId=" + deId + ", id=" + id + ", poName=" + poName + "]";
    }
}
