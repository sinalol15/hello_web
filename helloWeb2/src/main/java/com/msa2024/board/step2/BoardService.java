package com.msa2024.board.step2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.msa2024.board.step2.dao.BoardDAO;
import com.msa2024.board.step2.vo.BoardVO;

/*
 * MVC 
 * Model : B/L 로직을 구현하는 부분(service + dao)  
 * View  : 출력(jsp) 
 * Controller : model와 view에 대한 제어를 담당 
 */
public class BoardService  {
	private static final long serialVersionUID = 1L;
      
	BoardDAO boardsDAO = new BoardDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardService() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<BoardVO> list(BoardVO board) throws ServletException, IOException {
		return boardsDAO.list(board);
	}
	
	public BoardVO view(BoardVO board) throws ServletException, IOException {
		return boardsDAO.read(board);
	}
	
	public int delete(BoardVO board) throws ServletException, IOException {
		return boardsDAO.delete(board);
	}
	
	public BoardVO updateForm(BoardVO board) throws ServletException, IOException {
		return boardsDAO.read(board);
	}
	
	public int update(BoardVO board) throws ServletException, IOException {
		return boardsDAO.update(board);
	}
	
	public int insert(BoardVO board) throws ServletException, IOException {
		return boardsDAO.insert(board);
	}
	
}