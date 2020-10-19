package model;

/**
 * 员工类
 */
public class Staff {
	/* 员工编号 */
	private int staffId;
	/* 岗位 */
	private Post post;
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

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
		return "Staff [staffId=" + staffId + ", post=" + post + ", staffName=" + staffName + ", sex=" + sex
				+ ", birthday=" + birthday + ", idCard=" + idCard + ", inDay=" + inDay + ", workDay=" + workDay
				+ ", workType=" + workType + ", source=" + source + ", political=" + political + ", nation=" + nation
				+ ", nativePlace=" + nativePlace + ", phone=" + phone + ", email=" + email + ", height=" + height
				+ ", bloodType=" + bloodType + ", marital=" + marital + ", birthPlace=" + birthPlace + ", huKou="
				+ huKou + ", education=" + education + ", degree=" + degree + ", college=" + college + ", major="
				+ major + ", graduationDate=" + graduationDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthPlace == null) ? 0 : birthPlace.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((bloodType == null) ? 0 : bloodType.hashCode());
		result = prime * result + ((college == null) ? 0 : college.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((graduationDate == null) ? 0 : graduationDate.hashCode());
		result = prime * result + height;
		result = prime * result + ((huKou == null) ? 0 : huKou.hashCode());
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		result = prime * result + ((inDay == null) ? 0 : inDay.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((marital == null) ? 0 : marital.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result + ((nativePlace == null) ? 0 : nativePlace.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((political == null) ? 0 : political.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + sex;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + staffId;
		result = prime * result + ((staffName == null) ? 0 : staffName.hashCode());
		result = prime * result + ((workDay == null) ? 0 : workDay.hashCode());
		result = prime * result + ((workType == null) ? 0 : workType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (birthPlace == null) {
			if (other.birthPlace != null)
				return false;
		} else if (!birthPlace.equals(other.birthPlace))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (bloodType == null) {
			if (other.bloodType != null)
				return false;
		} else if (!bloodType.equals(other.bloodType))
			return false;
		if (college == null) {
			if (other.college != null)
				return false;
		} else if (!college.equals(other.college))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (graduationDate == null) {
			if (other.graduationDate != null)
				return false;
		} else if (!graduationDate.equals(other.graduationDate))
			return false;
		if (height != other.height)
			return false;
		if (huKou == null) {
			if (other.huKou != null)
				return false;
		} else if (!huKou.equals(other.huKou))
			return false;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		if (inDay == null) {
			if (other.inDay != null)
				return false;
		} else if (!inDay.equals(other.inDay))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (marital == null) {
			if (other.marital != null)
				return false;
		} else if (!marital.equals(other.marital))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (nativePlace == null) {
			if (other.nativePlace != null)
				return false;
		} else if (!nativePlace.equals(other.nativePlace))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (political == null) {
			if (other.political != null)
				return false;
		} else if (!political.equals(other.political))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (sex != other.sex)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (staffId != other.staffId)
			return false;
		if (staffName == null) {
			if (other.staffName != null)
				return false;
		} else if (!staffName.equals(other.staffName))
			return false;
		if (workDay == null) {
			if (other.workDay != null)
				return false;
		} else if (!workDay.equals(other.workDay))
			return false;
		if (workType == null) {
			if (other.workType != null)
				return false;
		} else if (!workType.equals(other.workType))
			return false;
		return true;
	}

}
