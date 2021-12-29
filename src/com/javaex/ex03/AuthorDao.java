//Dao만들기, AuthorVo사용하기

package com.javaex.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	// 필드

	// 생성자
	public AuthorDao() { // 생략가능
	}

	// 메소드 gs

	// 메소드 일반

	// 작가 추가
	public void authorInsert(AuthorVo authorVo) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행

			// 문자열 만들기
			String query = "";
			query += " insert into author ";
			query += " values(seq_author_id.nextval, ?, ? ) ";
			System.out.println(query);

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩
			pstmt.setString(1, authorVo.getAuthorName()); // 첫번째 물음표의 데이터
			pstmt.setString(2, authorVo.getAuthorDesc()); // 두번째 물음표의 데이터

			// 실행
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			System.out.println(count + " 건이 저장되었습니다.(작가)");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				/*
				 * if (rs != null) { rs.close(); }
				 */
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

	// 작가 삭제
	public void authorDelete(int index) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			// 문자열 만들기
			String query = "";
			query += " delete from author ";
			query += " where author_id = ? ";
			System.out.println(query);

			// 문자열 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩
			pstmt.setInt(1, index);

			// 실행
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + " 건이 삭제되었습니다.(작가)");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				/*
				 * if (rs != null) { rs.close(); }
				 */
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

	// 작가 수정
	public void authorUpdate(AuthorVo authorVo) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			// 문자열 만들기
			String query = "";
			query += " update author ";
			query += " set author_name = ?, ";
			query += "     author_desc = ? ";
			query += " where author_id = ? ";
			System.out.println(query);

			// 문자열을 쿼리문으로 만들기
			pstmt = conn.prepareStatement(query);

			// 바인딩
			pstmt.setString(1, authorVo.getAuthorName());
			pstmt.setString(2, authorVo.getAuthorDesc());
			pstmt.setInt(3, authorVo.getAuthorId());

			// 실행
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + " 건이 수정되었습니다.(작가)");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				/*
				 * if (rs != null) { rs.close(); }
				 */
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

	// 작가 리스트 가져오기
	public List<AuthorVo> authorSelect() {
		List<AuthorVo> authorList = new ArrayList<AuthorVo>(); //제네릭
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
		    query += " select author_id, ";
		    query += "  author_name, ";
		    query += "  author_desc ";
		    query += " from author ";
//		    query += " order by author_id asc ";//순서대로 하고싶다면
		    System.out.println(query);
		    
		    //문자열 쿼리문으로 만들기
		    pstmt = conn.prepareStatement(query);
		    //바인딩은 물음표가 없으니까 생략
		    
		    //실행--
		    //resultSet은 select문일때(결과물이 있어야함)
		    //int count는 insert, update, delete

		    rs = pstmt.executeQuery();
		    // 4.결과처리
		    
		    while(rs.next()) {
		    	int authorId /*내가지정한변수명*/ = rs.getInt("author_id"); //getInt(숫자컬럼명)
		    	String authorName = rs.getString(2); //getString(문자컬럼명)
		    	String authorDesc = rs.getString("author_desc"); //while 입력순서대로 출력됨 3번째컬럼꺼내옴 desc
		    	
		    	AuthorVo vo= new AuthorVo(authorId, authorName, authorDesc);
		    	authorList.add(vo);
		  }
		    
		    
		    

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
		return authorList;
	}

}
