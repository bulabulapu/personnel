package model;

/**
 * 岗位类
 */
public class Post {
    /*岗位编号 */
    private int poId;
    /*岗位名称 */
    private String poName;  
    /*部门编号 */
    private int deId;
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
	public int getDeId() {
		return deId;
	}
	public void setDeId(int deId) {
		this.deId = deId;
	}
	@Override
	public String toString() {
		return "Post [poId=" + poId + ", poName=" + poName + ", deId=" + deId + "]";
	}

}
