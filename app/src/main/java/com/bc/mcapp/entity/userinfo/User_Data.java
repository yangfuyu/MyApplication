package com.bc.mcapp.entity.userinfo;
/**
 * @Describe 
 * @Author 
 * @Date 2016-10-18 下午9:11:11
 */
public class User_Data {
	private String cmd;
	private String status;
	private UserInfo user;



	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public User_Data(String cmd, String status, UserInfo user) {
		super();
		this.cmd = cmd;
		this.status = status;
		this.user = user;
	}
	public User_Data() {
		super();
	}
	
}
