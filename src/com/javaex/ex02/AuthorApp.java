package com.javaex.ex02;

public class AuthorApp {

public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		
		//작가등록
		authorDao.authorInsert("이문열", "경북 영양");
		
		//작가등록
		authorDao.authorInsert("박경리", "경상남도 통영");
		
		
		List<AuthorVo> authorList = authorDao.authorSelect();
		
		
		
		//작가수정
		//authorDao.authorUpdate(2, "박경리(수정)", "경상남동 통영(수정)");
				
		
		//작가삭제 --->만들어보세요
		//authorDao.authorDelete(1);
		
		
		
		
		
		
		
		
		
	}


}
