package com.stx.bean;

/**
 * 实体类
 * 
 * @author 17476
 * 
 */
public class User {
	private int id;
	private String zh;
	private String pass;
	private String realname;
	private String mobile;
	private String type;

	public User(int id, String zh, String pass, String realname, String mobile,
			String type) {
		super();
		this.id = id;
		this.zh = zh;
		this.pass = pass;
		this.realname = realname;
		this.mobile = mobile;
		this.type = type;
	}

	public User(String zh, String pass, String realname, String mobile,
			String type) {
		super();
		this.zh = zh;
		this.pass = pass;
		this.realname = realname;
		this.mobile = mobile;
		this.type = type;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", zh=" + zh + ", pass=" + pass
				+ ", realname=" + realname + ", mobile=" + mobile + ", type="
				+ type + "]";
	}

}
