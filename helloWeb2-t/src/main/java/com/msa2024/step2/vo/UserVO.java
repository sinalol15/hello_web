package com.msa2024.step2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String userid;
	private String userpassword;
	private String username;
	private int    userage;
	private String usermail;
	
	private String userpassword2;
	//실행 명령 필드 
	private String action;

	public UserVO(String userid, String userpassword, String username, int userage, String usermail) {
		super();
		this.userid = userid;
		this.userpassword = userpassword;
		this.username = username;
		this.userage = userage;
		this.usermail = usermail;
	}
	
}