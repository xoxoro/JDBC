package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
				//책 데이터 가져오기
				// 0. import java.sql.*;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
				    // 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");

				    // 2. Connection 얻어오기
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					conn = DriverManager.getConnection(url, "webdb", "webdb");

				    // 3. SQL문 준비 / 바인딩 / 실행
				    String query = "";
				    query += " select book_id 아이디, ";
				    query += "  	  title, ";
				    query += "  	  pubs, ";
				    query += "  	  to_char(pub_date, '') pub_date, ";
				    query += "  	  author_id ";
				    query += " from book ";
				    System.out.println(query);
				    
				    //문자열 쿼리문으로 만들기
				    pstmt = conn.prepareStatement(query);
				    
				    //바인딩은 물음표가 없으니까 생략
				    
				    //실행--
				    //resultSet은 select문일때(결과물이 있어야함)
				    //int count는 insert, update, delete

				    rs = pstmt.executeQuery();
				    
				    // 4.결과처리
				    //while--> row의 갯수만큼 반복
				    while(rs.next()) {
				    	int bookId /*내가지정한변수명*/ = rs.getInt("아이디"); //getInt(숫자컬럼명)
				    	String title = rs.getString("author_name"); //getString(문자컬럼명)
				    	String pubs = rs.getString(3); //while 입력순서대로 출력됨 3번째컬럼꺼내옴 desc
				    	
				    	System.out.println(authorId + ", " + authorName + ", " + authorDesc);
				    }

				    //리스트 BookVo만들기
				    
				    
				} catch (ClassNotFoundException e) {
				    System.out.println("error: 드라이버 로딩 실패 - " + e);
				} catch (SQLException e) {
				    System.out.println("error:" + e);
				} finally {
				   
				    // 5. 자원정리
				    try {
				        if (rs != null) {
				            rs.close();
				        }                
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
