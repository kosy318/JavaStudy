package com.book3;

import java.util.ArrayList;

// Book을 관리하기 위해 필요한 메소드가 표시된 인터페이스
public interface IBookManager {
	
	void add(Book book) throws DuplicatedISBNException;
	void remove(String isbn) throws NoSuchBookException;
	Book findByIsbn(String isbn) throws NoSuchBookException;
	ArrayList<Book> findByTitle(String title) throws NoResultException; 
	
	ArrayList<Magazine> getMagazines() throws NoResultException;
	ArrayList<Novel> getNovels() throws NoResultException;
	int getTotalPrice();
	double getPriceAverage();
	
	ArrayList<Magazine> findMagazineByYear(int year) throws NoResultException; 
	ArrayList<Book> findByPrice(int price1, int price2) throws NoResultException; 
	ArrayList<Book> findByPublisher(String publisher) throws NoResultException;

	ArrayList<Book> getList();
	
}
