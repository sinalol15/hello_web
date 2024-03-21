package com.msa2024.step2.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
	private String userid;
	private String userpassword;
	private String username;
	private int    userage;
	private String usermail;
	
	private String userpassword2;
	private String err;
	//실행 명령 필드 
	private String action;

	//검색키
	private String searchKey;
	
	//uuid
	private String useruuid;
	
	//자동로그인 여부
	private String autologin;
	
	public UserVO(String userid, String userpassword, String username, int userage, String usermail) {
		super();
		this.userid = userid;
		this.userpassword = userpassword;
		this.username = username;
		this.userage = userage;
		this.usermail = usermail;
	}
	
	public boolean isEmptySearchKey() {
		return searchKey == null || searchKey.length() == 0; 
	}
	
	public boolean isEqualPassword(UserVO userVO) {
		return userVO != null && userpassword.equals(userVO.getUserpassword()); 

	}
}