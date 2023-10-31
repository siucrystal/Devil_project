package com.daily.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private int sex;
	private int age;
	
	public MemberDTO() {
		super();

	}
	
	public MemberDTO(String id, String pw,String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public MemberDTO(String id, String pw, String name, int sex, int age) {
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}
