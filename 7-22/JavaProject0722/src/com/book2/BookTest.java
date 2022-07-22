package com.book2;

public class BookTest {
	public static void main(String[] args) {
		BookManager bm = BookManager.getInstance();
		
		bm.add(new Magazine("34655", "Java 잡지1", "김하나", "jaen.kr", 15000, "Java 기본 문법", 2022, 7));
		bm.add(new Novel("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", "참고서"));
		bm.add(new Magazine("14212", "c++ 잡지2", "김하나", "jaen.kr", 25000, "Java 응용", 2022, 8));
		bm.add(new Novel("12323", "c++ 소설1", "김하나", "jaen.kr", 15000, "Java 기본 문법", "공부"));
		bm.add(new Magazine("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 2021, 1));
		bm.add(new Novel("12345", "Java 소설2", "김하나", "jaen.kr", 25000, "Java 응용", "공부"));
		bm.add(new Magazine("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 2022, 4));
		
		System.out.println("*********************도서목록*********************");
		Book[] existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		String isbn = "21424";
		System.out.println("*********************도서조회:" + isbn +"*********************");
		System.out.println(bm.findByIsbn(isbn));
		
		System.out.println("*********************도서삭제:" + isbn +"*********************");
		bm.remove(isbn);
		
		System.out.println("*********************도서목록*********************");
		existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************Magazine 목록*********************");
		existBooks = bm.getMagazines();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************Novel 목록*********************");
		existBooks = bm.getNovels();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************c++을 제목에 포함하는 책*********************");
		existBooks = bm.findByTitle("c++");
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************도서목록*********************");
		existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println();
		System.out.println("total price : " + bm.getTotalPrice() + ", price average : " + bm.getPriceAverage());
	}
}
