package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert2 {

	public static void main(String[] args) {
		// insert문
		
				// 0. import java.sql.*;
				Connection conn = null;
				PreparedStatement pstmt = null;
				//ResultSet rs = null;

				try {
				    // 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");

				    // 2. Connection 얻어오기
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					conn = DriverManager.getConnection(url, "webdb", "webdb");
					System.out.println("접속성공");

					
				    // 3. SQL문 준비 / 바인딩 / 실행 
					//문자열 만들기 -- ?주의
				    String query = ""; 
				    query += " insert into book ";
				    query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";
				    System.out.println(query);

				    //문자열 쿼리문으로 만들기
				    pstmt = conn.prepareStatement(query);
				    
				    
				    ///////////////////////////////
				    //--(순정만화/강풀)
					//////////////////////////////
				    //바인딩
				    pstmt.setString(1, "순정만화"); //첫번째 물음표의 데이터
				    pstmt.setString(2, "재미주의"); //두번째 물음표의 데이터
				    pstmt.setString(3, "2011-08-03");
				    pstmt.setInt(4, 5);
				    //실행
				    int count = pstmt.executeUpdate(); //쿼리문 실행
				    // 4.결과처리
				    System.out.println(count+ " 건이 저장되었습니다.(book)");
				    
				    
				    //////////////////////////////////
				    //오직 두사람/김영하
				    /////////////////////////////////
				    //문자열만들기
				    pstmt.setString(1, "오직 두사람");
				    pstmt.setString(2, "문학동네");
				    pstmt.setString(3, "2017-05-04");
				    pstmt.setInt(4, 6);
				    //실행
				    int count2 = pstmt.executeUpdate(); //쿼리문 실행
				    // 4.결과처리
				    System.out.println(count2+ " 건이 저장되었습니다.(book)");
				    
				    
				} catch (ClassNotFoundException e) {
				    System.out.println("error: 드라이버 로딩 실패 - " + e);
				} catch (SQLException e) {
				    System.out.println("error:" + e);
				} finally {
				   
				    // 5. 자원정리
				    try {
				                  
				        if (pstmt != null) {
				            pstmt.close();
				        }
				        if (conn != null) {
				            conn.close();
				        }
				    } catch (SQLException e) {
				        System.out.println("error:" + e);
				    }

				}
	}

}
