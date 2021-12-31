package com.javaex.ex05;

import java.util.ArrayList;
import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		List<BookVo> bookList = new ArrayList<>();
		BookDao bookDao = new BookDao();
		
		//책 추가
		System.out.println("*********** 책 추가 **************");
		BookVo vo01 = new BookVo("책제목1", "출판사1", "2002-05-08",1);
		bookDao.BookInsert(vo01);
		BookVo vo02 = new BookVo("책제목2", "출판사2", "2008-01-28",2);
		bookDao.BookInsert(vo02);
		System.out.println();
		
		bookList = bookDao.bookSelect();
		for(BookVo vo : bookList) {
			System.out.println(vo.getBookId()+", "+vo.getTitle()+", "+vo.getPubs()+", "+vo.getPubDate()+", "+vo.getAuthorId()+", "+vo.getAuthorName()+", "+vo.getAuthorDesc());
		}
		System.out.println();
		
		// 책 수정
		System.out.println("*********** 책 수정 **************");
		BookVo vo03 = new BookVo(2,"책제목3", "출판사3", "1234-12-30",1);
		bookDao.bookUpdate(vo03);
		bookList = bookDao.bookSelect();
		System.out.println();
		
		for(BookVo vo : bookList) {
			System.out.println(vo.getBookId()+", "+vo.getTitle()+", "+vo.getPubs()+", "+vo.getPubDate()+", "+vo.getAuthorId()+", "+vo.getAuthorName()+", "+vo.getAuthorDesc());
		}
		System.out.println();
		
		// 책 삭제
		System.out.println("*********** 책 삭제 **************");
		bookDao.bookDelete(1);
		bookDao.bookDelete(2);
		System.out.println();
		
		bookList = bookDao.bookSelect();
		for(BookVo vo : bookList) {
			System.out.println(vo.getBookId()+", "+vo.getTitle()+", "+vo.getPubs()+", "+vo.getPubDate()+", "+vo.getAuthorId()+", "+vo.getAuthorName()+", "+vo.getAuthorDesc());
		}
		System.out.println();
		
		
	}

}