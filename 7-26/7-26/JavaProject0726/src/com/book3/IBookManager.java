package com.book3;

import java.util.ArrayList;

// Book을 관리하기 위해 필요한 메소드가 표시된 인터페이스
public interface IBookManager {
	
	void add(Book book);
	void remove(String isbn);
	Book findByIsbn(String isbn);
	ArrayList<Book> findByTitle(String title);
	
	ArrayList<Magazine> getMagazines();
	ArrayList<Novel> getNovels();
	int getTotalPrice();
	double getPriceAverage();
	
	ArrayList<Magazine> findMagazineByYear(int year);
	ArrayList<Book> findByPrice(int price1, int price2);
	ArrayList<Book> findByPublisher(String publisher);

	ArrayList<Book> getList();
	
}
