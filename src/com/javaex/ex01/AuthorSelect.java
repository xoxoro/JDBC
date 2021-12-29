package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorSelect {

	public static void main(String[] args) {
		
		List<AuthorVo> authorList = new ArrayList<AuthorVo>(); //제네릭		
		
		// 작가 데이터 가져오기
		
		
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
		    query += " select author_id 아이디, ";//이름변경할때 뒤에 글자추가
		    query += "  author_name, ";
		    query += "  author_desc "; //콤마 안찍는거 빼먹지말기
		    query += " from author ";
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
		    	int authorId /*내가지정한변수명*/ = rs.getInt("아이디"); //getInt(숫자컬럼명)
		    	String authorName = rs.getString("author_name"); //getString(문자컬럼명)
		    	String authorDesc = rs.getString(3); //while 입력순서대로 출력됨 3번째컬럼꺼내옴 desc
		    	
		    	AuthorVo vo= new AuthorVo(authorId, authorName, authorDesc);
		    	
		    	//정렬시키기위해 주소값 넣기
		    	authorList.add(vo);
		    	
		    	
		    	//System.out.println(authorId + ", " + authorName + ", " + authorDesc); -->정렬없을때 입력표기
	
		    }
		    
		    //출력
		    //0부터니까 사이즈가 n개면 i<n임
		    for(int i=0; i<authorList.size(); i++) {
		    	AuthorVo authorVo = authorList.get(i);
		    	System.out.println(authorVo.getAuthorId() + ", " + authorVo.getAuthorName() + ", " + authorVo.getAuthorDesc());
		    }
		    
		    //첫번째 작가 이름만 다시 출력
		    AuthorVo authorVo = authorList.get(0);
		    System.out.println(authorVo.getAuthorName());
		    
		    
		    

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
