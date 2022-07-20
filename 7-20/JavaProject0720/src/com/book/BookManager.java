package com.book;

import java.util.Arrays;

import com.member.Member;

public class BookManager {
	
	int MAX_SIZE = 100;
	Book[] books = new Book[MAX_SIZE];
	int size;
	
	public void add(Book book) {
		if(size < MAX_SIZE) {
			for(int i=0; i<MAX_SIZE; i++) {
				if(books[i] == null) {
					books[i] = book;
					size += 1;
//					System.out.println("책 정보가 추가되었습니다.");
					break;
				}
			}
		} //else System.out.println("더 이상 추가할 수 없습니다.");
	}
	
	public void remove(String isbn) {
		boolean found = false;
		for(int i=0; i<MAX_SIZE; i++) {
			if(books[i]!=null && books[i].isbn.equals(isbn)) {
//				System.out.println(isbn + " 번 책이 삭제되었습니다");
				books[i] = null;
				found = true;
				size -= 1;
				break;
			}
		}
//		if(!found) System.out.println(isbn + " 번 책을 찾지 못했습니다.");		
	}
	
	public Book[] getList() {
		Book[] existBook = new Book[size];
		int idx = 0;
		for(Book b : books) {
			if(b != null) {
				existBook[idx] = b;
				idx += 1;
			}
			if(idx == size) break;
		}
//		System.out.println("총 " + size + "권의 정보가 있습니다.");
		return existBook;
	}
	
	public Book searchByIsbn(String isbn) {
		for(Book b: books) {
			if(b!=null && b.isbn.equals(isbn)) {
//				System.out.println(isbn + " 번 책을 찾았습니다.");
				return b;
			}
		}
//		System.out.println(isbn + " 번 책을 찾지 못했습니다.");
		return null;
	}
	
}
