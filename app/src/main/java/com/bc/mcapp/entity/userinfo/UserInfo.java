package com.bc.mcapp.entity.userinfo;
/**
 * @Describe 
 * @Author 
 * @Date 2016-10-18 下午9:12:11
 */
public class UserInfo {
	private String icon;
	private String loginId;
	private String loginPwd;
	private int score;
	private String userName;
	private int sex;
	private String birthday;
	
	public String getBrithday() {
		return birthday;
	}
	public void setBrithday(String birthday) {
		this.birthday = birthday;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public UserInfo(String icon, String loginId, String loginPwd, int score,
			String userName,int sex,String birthday) {
		super();
		this.icon = icon;
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.score = score;
		this.userName = userName;
		this.sex = sex;
		this.birthday = birthday;
	}
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [icon=" + icon + ", loginId=" + loginId
				+ ", loginPwd=" + loginPwd + ", score=" + score + ", userName="
				+ userName + ", sex=" + sex + ", birthday=" + birthday + "]";
	}
	
	
	
}
