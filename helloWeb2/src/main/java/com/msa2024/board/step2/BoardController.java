package com.msa2024.board.step2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msa2024.board.step2.vo.BoardVO;
import com.msa2024.step2.vo.UserVO;

public class BoardController {
	private static final long serialVersionUID = 1L;

	//xml 또는 어노터이션 처리하면 스프링 
	//어노터이션 처리하면 스프링 부트   
	BoardService boardService = new BoardService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public Object list(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("목록");
		
		//1. 처리
		List<BoardVO> list = boardService.list(board);
		
		//2. jsp출력할 값 설정
		request.setAttribute("list", list);
		
		return "list";
	}
	
	public Object view(HttpServletRequest request, BoardVO board, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("상세보기");
		request.setAttribute("board", boardService.view(board));
		
		//1. viewTodos의 쿠키 값을 얻는다.
		Cookie[] cookies = request.getCookies();
		String viewTodos="";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("viewTodos")) {
				viewTodos = cookie.getValue();
				
				if (viewTodos == null || viewTodos.length() == 0) {
					viewTodos = "-" + board.getBno() + "-";
				} else {
					//-4-8-10-12-
					//이전에 게시물 상세보기를 했는지 확인한다
					if (!viewTodos.contains("-" + board.getBno() + "-")) {
						//상세보기를 하지 않은 경우 쿠키문자열에 게시물 번호를 추가한다.
						viewTodos += board.getBno() + "-";
					}
				}
			}
		}
		if (viewTodos == null || viewTodos.length() == 0) {
			viewTodos = "-" + board.getBno() + "-";
		}
		System.out.println("상세보기를 한 문자열 : " + viewTodos);
				
		//브라우저로 보낼 쿠키를 생성하여 추가한다.
		Cookie newCookie = new Cookie("viewTodos", viewTodos);
		newCookie.setMaxAge(24*60*60);
		response.addCookie(newCookie);
		
		return "view";
	}
	
	public Object delete(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("삭제");
		//1. 처리
		int updated = boardService.delete(board);
		
		Map<String, Object> map = new HashMap<>();
		
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "회원 정보 삭제 실패하였습니다");
		}
		return map;
	}
	
	public Object updateForm(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("수정화면");
		request.setAttribute("board", boardService.updateForm(board));
		
		return "updateForm"; 
	}
	
	public Object update(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("수정");
		
		//1. 처리
		int updated = boardService.update(board);
		
		Map<String, Object> map = new HashMap<>();
		
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시물 수정에 실패하였습니다");
		}
		return map;
	}
	
	public Object insertForm(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("등록화면");
		//1. 처리
		
		//2. jsp출력할 값 설정
		return "insertForm";
	}
	
	public Object insert(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("등록");
		Map<String, Object> map = new HashMap<>();
		
		//전처리로 세션정보를 얻는다
		HttpSession session = request.getSession();
		System.out.println("게시물등록시 sessionId = " + session.getId());
		
		UserVO loginVO = (UserVO) session.getAttribute("loginVO");
		if (loginVO != null) {
			board.setBwriter(loginVO.getUsername());
		}
		
		//1. 처리
		int updated = boardService.insert(board);
		
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시물 등록에 실패하였습니다");
		}
		
		return map;
	}
	
}