package com.msa2024.board.step2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.msa2024.board.step2.vo.BoardVO;

public class BoardDAO {
    // 1. 회원가입 목록 만들기
    // 2. 삭제 구현
    // 3. 수정 구현
    // 4. 상세보기 구현
    // 5. 전체삭제 구현
    // 6. 등록 구현
    private static Connection conn = null;
    private static PreparedStatement boardListPstmt = null;
    private static PreparedStatement boardListPstmt2 = null;
    private static PreparedStatement boardInsertPstmt = null;
    private static PreparedStatement boardDeletePstmt = null;
    private static PreparedStatement boardDetailPstmt = null;

    private static PreparedStatement boardUpdatePstmt = null;
    private static PreparedStatement boardDeleteAllPstmt = null;

    static {

        try {
            // 1. JDBC 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");
            // 2. DB 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );
            // 3. SQL 실행 객체 준비
            // 4. SQL 실행
            System.out.println("연결 성공");
            conn.setAutoCommit(false);

            boardListPstmt = conn.prepareStatement("select * from boards order by bno");
            boardListPstmt2 = conn.prepareStatement("select * from boards where btitle like ? order by bno");
            boardInsertPstmt = conn.prepareStatement("insert into boards (bno, btitle, bcontent, bwriter) values (seq_bno.nextval, ?, ?, ?)");
            boardDetailPstmt = conn.prepareStatement("select * from boards where bno = ?");
            //delete 가 되지 않았던 이유: ? 개수에 맞춰서 setString() 을 해주어야 한다.
            boardDeletePstmt = conn.prepareStatement("delete from boards where bno = ?");
            boardDeleteAllPstmt = conn.prepareStatement("delete from boards");
            boardUpdatePstmt = conn.prepareStatement("update boards set btitle = ?, bcontent = ? where bno = ?");
            // 5. 결과 처리
            // 6. 연결 해제
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<BoardVO> list(BoardVO board) {
        List<BoardVO> list = new ArrayList<>();
        try {
        	ResultSet rs = null;
        	if (board != null && !board.isEmptySearchKey()) {
        		//검색 키워드 설정 
        		boardListPstmt2.setString(1, "%" + board.getSearchKey() + "%");
        		rs = boardListPstmt2.executeQuery();
        	} else {
                rs = boardListPstmt.executeQuery();
        	}
            while (rs.next()) {
                BoardVO boards = new BoardVO(rs.getInt("bno")
                        , rs.getString("btitle")
                        , rs.getString("bcontent")
                        , rs.getString("bwriter")
                        , rs.getString("bdate"));
                
                list.add(boards);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int insert(BoardVO users){
        int updated = 0;
        try{
            boardInsertPstmt.setString(1, users.getBtitle());
            boardInsertPstmt.setString(2, users.getBcontent());
            boardInsertPstmt.setString(3, users.getBwriter());
            updated = boardInsertPstmt.executeUpdate();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }
    public BoardVO read(BoardVO user) {

        BoardVO boards = null;
        try {
            boardDetailPstmt.setInt(1, user.getBno());

            ResultSet rs = boardDetailPstmt.executeQuery();
            if (rs.next()) {
                boards = new BoardVO(rs.getInt("bno")
                        , rs.getString("btitle")
                        , rs.getString("bcontent")
                        , rs.getString("bwriter")
                        , rs.getString("bdate"));
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return boards;
    }

    public int update(BoardVO board) {
        int updated = 0;
        try {
        	boardUpdatePstmt.setString(1, board.getBtitle());
            boardUpdatePstmt.setString(2, board.getBcontent());
            boardUpdatePstmt.setInt(3, board.getBno());
            updated = boardUpdatePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;

    }

    public int delete(BoardVO board) {
        int updated = 0;

        try {
            boardDeletePstmt.setInt(1, board.getBno());
            updated = boardDeletePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int clear() {
        int updated = 0;
        try {
            updated = boardDeleteAllPstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }
}