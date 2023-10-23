package com.daily.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String sex;
	private String age;
	
	public MemberDTO() {
		super();

	}
	
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public MemberDTO(String id, String pw, String name, String sex, String age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}