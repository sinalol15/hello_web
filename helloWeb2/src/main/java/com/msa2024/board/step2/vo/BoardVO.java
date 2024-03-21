package com.msa2024.board.step2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bdate;
	
	//실행 명령 필드 
	private String action;
	
	//검색키
	private String searchKey;
	
	public boolean isEmptySearchKey() {
		return searchKey == null || searchKey.length() == 0; 
	}
	
	public BoardVO(int bno, String btitle, String bcontent, String bwriter, String bdate) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}
	
	public BoardVO(int bno, String btitle, String bcontent, String bwriter) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
	}
	
	public BoardVO(String btitle, String bcontent, String bwriter) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
	}
	
}
