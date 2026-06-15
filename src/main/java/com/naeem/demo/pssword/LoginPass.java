package com.naeem.demo.pssword;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginPass {
	@Id
	private String password;
	private String name;
	
	
	
	public LoginPass() {
		
	}
	public LoginPass(String password, String name) {
		
		this.password = password;
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
