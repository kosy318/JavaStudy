package com.book3;

import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args) {
		BookManager bm = BookManager.getInstance();
		
		try {
			bm.add(new Magazine("34655", "Java 잡지1", "김하나", "jaen.kr", 15000, "Java 기본 문법", 2022, 7));
			bm.add(new Novel("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", "참고서"));
			bm.add(new Magazine("14212", "c++ 잡지2", "김하나", "ssafy.kr", 25000, "Java 응용", 2022, 8));
			bm.add(new Novel("12323", "c++ 소설1", "김하나", "jaen.kr", 15000, "Java 기본 문법", "공부"));
			bm.add(new Magazine("21424", "Java Pro", "김하나", "ssafy.kr", 15000, "Java 기본 문법", 2021, 1));
			bm.add(new Novel("12345", "Java 소설2", "김하나", "jaen.kr", 40000, "Java 응용", "공부"));
			bm.add(new Magazine("21425", "Java Pro2", "김하나", "ssafy.kr", 25000, "Java 응용", 2021, 4));
//			bm.add(new Magazine("21425", "Java Pro2", "김하나", "ssafy.kr", 25000, "Java 응용", 2021, 4));
			
			System.out.println("*********************도서목록*********************");
			ArrayList<Book> existBooks = bm.getList();
			for(Book b : existBooks)
				System.out.println(b);
			
			String isbn = "21424";
			System.out.println("*********************도서조회:" + isbn +"*********************");
			System.out.println(bm.findByIsbn(isbn));
//			isbn = "2142334";
//			System.out.println("*********************도서조회:" + isbn +"*********************");
//			System.out.println(bm.findByIsbn(isbn));
			
			System.out.println("*********************도서삭제:" + isbn +"*********************");
			bm.remove(isbn);
//			bm.remove(isbn);
			
			System.out.println("*********************도서목록*********************");
			existBooks = bm.getList();
			for(Book b : existBooks)
				System.out.println(b);
			
			System.out.println("*********************Magazine 목록*********************");
			ArrayList<Magazine> existMagazines = bm.getMagazines();
			for(Book b : existMagazines)
				System.out.println(b);
			
			System.out.println("*********************Novel 목록*********************");
			ArrayList<Novel> existNovel = bm.getNovels();
			for(Book b : existNovel)
				System.out.println(b);
			
			System.out.println("*********************c++을 제목에 포함하는 책*********************");
			existBooks = bm.findByTitle("c++");
			for(Book b : existBooks)
				System.out.println(b);
//			System.out.println("*********************고수연을 제목에 포함하는 책*********************");
//			existBooks = bm.findByTitle("고수연");
//			for(Book b : existBooks)
//				System.out.println(b);
			
			System.out.println("*********************2022년도 Magazine 목록*********************");
			existMagazines = bm.findMagazineByYear(2022);
			for(Book b : existMagazines)
				System.out.println(b);
//			System.out.println("*********************2002년도 Magazine 목록*********************");
//			existMagazines = bm.findMagazineByYear(2002);
//			for(Book b : existMagazines)
//				System.out.println(b);
			
			System.out.println("*********************20000~30000사이 책*********************");
			existBooks = bm.findByPrice(20000, 30000);
			for(Book b : existBooks)
				System.out.println(b);
//			System.out.println("*********************0~1사이 책*********************");
//			existBooks = bm.findByPrice(0, 1);
//			for(Book b : existBooks)
//				System.out.println(b);
			
			System.out.println("*********************ssafy.kr이 출판한 책*********************");
			existBooks = bm.findByPublisher("ssafy.kr");
			for(Book b : existBooks)
				System.out.println(b);
//			System.out.println("*********************ssafy8.kr이 출판한 책*********************");
//			existBooks = bm.findByPublisher("ssafy8.kr");
//			for(Book b : existBooks)
//				System.out.println(b);
			
			System.out.println();
			System.out.println("total price : " + bm.getTotalPrice() + ", price average : " + bm.getPriceAverage());
			
		} catch(DuplicatedISBNException | NoResultException | NoSuchBookException e) {
			System.out.println(e);
		}
		
	}
}