package model;

/**
 * 部门
 */
public class Department {
    /*部门id */
    private int id;
    /*部门名称 */
    private String deName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeName() {
        return deName;
    }

    public void setDeName(String deName) {
        this.deName = deName;
    }

    @Override
    public String toString() {
        return "Department [deName=" + deName + ", id=" + id + "]";
    }
}
