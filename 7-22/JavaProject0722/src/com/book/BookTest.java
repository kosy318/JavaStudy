package com.book;

public class BookTest {
	public static void main(String[] args) {
		BookManager bm = new BookManager();
		
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		System.out.println("*********************도서목록*********************");
		Book[] existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		String isbn = "21424";
		System.out.println("*********************도서조회:" + isbn +"*********************");
		System.out.println(bm.searchByIsbn(isbn));
		
		System.out.println("*********************도서삭제:" + isbn +"*********************");
		bm.remove(isbn);
		
		System.out.println("*********************도서목록*********************");
		existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
	}
}
