package com.msa2024;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardsDAO {
    // 1. 회원가입 목록 만들기
    // 2. 삭제 구현
    // 3. 수정 구현
    // 4. 상세보기 구현
    // 5. 전체삭제 구현
    // 6. 등록 구현
    private static Connection conn = null;
    private static PreparedStatement userListPstmt = null;
    private static PreparedStatement userInsertPstmt = null;
    private static PreparedStatement userDeletePstmt = null;
    private static PreparedStatement userDetailPstmt = null;

    private static PreparedStatement userUpdatePstmt = null;
    private static PreparedStatement userDeleteAllPstmt = null;

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

            userListPstmt = conn.prepareStatement("select * from boards ORDER BY bno");
            userInsertPstmt = conn.prepareStatement("insert into boards (bno, btitle, bcontent, bwriter, bdate) values (seq_bno.nextval, ?, ?, ?,sysdate)");
            userDetailPstmt = conn.prepareStatement("select * from boards where bno=?");
            //delete 가 되지 않았던 이유: ? 개수에 맞춰서 setString() 을 해주어야 한다.
            userDeletePstmt = conn.prepareStatement("delete from boards where bno=?");
            userDeleteAllPstmt = conn.prepareStatement("delete from boards");
            userUpdatePstmt = conn.prepareStatement("update boards set bwriter=?, btitle=?, bcontent=? where bno=?");
            // 5. 결과 처리
            // 6. 연결 해제
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<Boards> list() {
        List<Boards> list = new ArrayList<>();
        try {
            ResultSet rs = BoardsDAO.userListPstmt.executeQuery();
            while (rs.next()) {
                Boards board = new Boards(rs.getInt("bno")
                        , rs.getString("bwriter")
                        , rs.getString("btitle")
                        , rs.getString("bcontent")
                        , rs.getString("bdate"));
                
                list.add(board);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int insert(Boards boards){
        int updated = 0;
        try{
            userInsertPstmt.setString(1, boards.getBwriter());
            userInsertPstmt.setString(2, boards.getBtitle());
            userInsertPstmt.setString(3, boards.getBcontent());
            
            updated = userInsertPstmt.executeUpdate();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }
    public Boards read(int bno) {

        Boards board = null;
        try {
            userDetailPstmt.setInt(1, bno);

            ResultSet rs = userDetailPstmt.executeQuery();
            if (rs.next()) {
                board = new Boards(rs.getInt("bno")
                        , rs.getString("bwriter")
                        , rs.getString("btitle")
                        , rs.getString("bcontent")
                        , rs.getString("bdate"));
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;
    }

    public int update(Boards board) {
        int updated = 0;
        try {
            userUpdatePstmt.setString(1, board.getBwriter());
            userUpdatePstmt.setString(2, board.getBtitle());
            userUpdatePstmt.setString(3, board.getBcontent());
            userUpdatePstmt.setInt(4, board.getBno());
            updated = userUpdatePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;

    }

    public int delete(int bno) {
        int updated = 0;

        try {
            userDeletePstmt.setInt(1, bno);
            updated = userDeletePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int clear() {
        int updated = 0;
        try {
            updated = userDeleteAllPstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }
}