package oopOdev4.entities.dtos;

import oopOdev4.entities.abstracts.Dto;

public class UserToLoginDto implements Dto{
	private String email;
	private String password;
	public UserToLoginDto() {
		
	}
	
	public UserToLoginDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
