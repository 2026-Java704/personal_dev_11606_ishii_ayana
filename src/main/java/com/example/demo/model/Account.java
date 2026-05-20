package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {
	private String name;
	private String email;
	private String password;
	private Integer age;
	private Integer gender;

	public Account() {

	}

	public Account(String name, String email, String password, Integer age, Integer gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}