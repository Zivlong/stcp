package com.stx.bean;

import java.sql.Date;

public class Cp {
	private int id;
	private String uname;
	private String tname;
	private String title;
	private String content;
	private Date createtime;

	public Cp(int id, String uname, String tname, String title, String content,
			Date createtime) {
		super();
		this.id = id;
		this.uname = uname;
		this.tname = tname;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
	}

	public Cp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cp(String uname, String tname, String title, String content,
			Date createtime) {
		super();
		this.uname = uname;
		this.tname = tname;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
