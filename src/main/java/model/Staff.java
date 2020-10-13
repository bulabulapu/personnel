package model;

/**
 * 员工类
 */
public class Staff {
    /* 员工编号 */
    private int id;
    /* 岗位编号 */
    private int poId;
    /* 姓名 */
    private String staffName;
    /* 性别 */
    private int sex;
    /* 出生日期 */
    private String birthday;
    /* 身份证号 */
    private String idCard;
    /* 入职日期 */
    private String inDay;
    /* 参加工作日期 */
    private String workDay;
    /* 用工形式 */
    private String workType;
    /* 人员来源 */
    private String source;
    /* 政治面貌 */
    private String political;
    /* 民族 */
    private String nation;
    /* 籍贯 */
    private String nativePlace;
    /* 联系电话 */
    private String phone;
    /* 电子邮件 */
    private String email;
    /* 身高 */
    private int height;
    /* 血型 */
    private String bloodType;
    /* 婚姻状况 */
    private String marital; 
    /* 出生地 */
    private String birthPlace;
    /* 户口所在地 */
    private String huKou;
    /* 最高学历 */
    private String education;
    /* 最高学位 */
    private String degree;
    /* 毕业院校 */
    private String college;
    /* 所学专业 */
    private String major;
    /* 毕业日期 */
    private String graduationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getInDay() {
        return inDay;
    }

    public void setInDay(String inDay) {
        this.inDay = inDay;
    }

    public String getWorkDay() {
        return workDay;
    }

    public void setWorkDay(String workDay) {
        this.workDay = workDay;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getHuKou() {
        return huKou;
    }

    public void setHuKou(String huKou) {
        this.huKou = huKou;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    @Override
    public String toString() {
        return "Staff [birthPlace=" + birthPlace + ", birthday=" + birthday + ", bloodType=" + bloodType + ", college="
                + college + ", degree=" + degree + ", education=" + education + ", email=" + email + ", graduationDate="
                + graduationDate + ", height=" + height + ", huKou=" + huKou + ", id=" + id + ", idCard=" + idCard
                + ", inDay=" + inDay + ", major=" + major + ", marital=" + marital + ", nation=" + nation
                + ", nativePlace=" + nativePlace + ", phone=" + phone + ", poId=" + poId + ", political=" + political
                + ", sex=" + sex + ", source=" + source + ", staffName=" + staffName + ", workDay=" + workDay
                + ", workType=" + workType + "]";
    }
}