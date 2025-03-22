package com.ht.member.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloData {
	private String username;
	private int age;
	
	public int getAge() {
		return age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
