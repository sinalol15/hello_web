package com.msa2024;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersServlet
 */
public class BoardsServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
      
   BoardsDAO boardsDAO = new BoardsDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doService(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doService(request, response);
   }
   
   //공통 처리 함수 
   private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
	  String action = request.getParameter("action");
      switch(action) {
      case "list" -> list(request, response);
      case "view" -> view(request, response);
      case "delete" -> delete(request, response);
      case "updateForm" -> updateForm(request, response);
      case "update" -> update(request, response);
      case "insertForm" -> insertForm(request, response);
      case "insert" -> insert(request, response);
     }
      
      //3. jsp 포워딩 
      //포워딩 
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/users/"+action+".jsp");
      rd.forward(request, response);
      
   }

   private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("목록");
      
      //1. 처리
      List<Boards> list = boardsDAO.list();
      
      //2. jsp출력할 값 설정
      request.setAttribute("list", list);
   }
   
   private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("상세보기");
	      int bno = Integer.parseInt(request.getParameter("bno"));
	      //1. 처리
	      Boards board = boardsDAO.read(bno);
	      
	      //2. jsp출력할 값 설정
	      request.setAttribute("board", board);
   }
   
   private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("삭제");
	      int bno = Integer.parseInt(request.getParameter("bno"));

	      //1. 처리
	      int board = boardsDAO.delete(bno);
	      
	      //2. jsp출력할 값 설정
	      request.setAttribute("board", board);
   }
   
   private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("수정 양식");
	      int bno = Integer.parseInt(request.getParameter("bno"));

	      //1. 처리
	      Boards board = boardsDAO.read(bno);
	      
	      //2. jsp출력할 값 설정
	      request.setAttribute("board", board);
   }
   
   private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("수정");
	      int bno = Integer.parseInt(request.getParameter("bno"));
	      String bwriter = request.getParameter("bwriter");
	      String btitle = request.getParameter("btitle");
	      String bcontent = request.getParameter("bcontent");	      

	      Boards board = new Boards(bno, btitle, bcontent, bwriter);
	      //1. 처리
	      int boards = boardsDAO.update(board);
	      
	      //2. jsp출력할 값 설정
	      request.setAttribute("board", boards);
	      }
   
   private void insertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("입력 양식");
   }
   
   private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("추가");
	      String bwriter = request.getParameter("bwriter");
	      String btitle = request.getParameter("btitle");
	      String bcontent = request.getParameter("bcontent");
	      
	      Boards board = new Boards(btitle, bcontent, bwriter);
	      //1. 처리
	      int updated = boardsDAO.insert(board);
	      
	      //2. jsp출력할 값 설정
	      request.setAttribute("board", updated);
   }
}
