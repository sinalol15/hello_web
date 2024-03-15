package com.msa2024;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boards {
   private int bno;
   private String btitle;
   private String bcontent;
   private String bwriter;
   private String bdate;
   
	public Boards(int bno, String btitle, String bcontent, String bwriter) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
	}
	
	public Boards(String btitle, String bcontent, String bwriter) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
	}
	
}