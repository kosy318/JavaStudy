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
//					System.out.println("å ������ �߰��Ǿ����ϴ�.");
					break;
				}
			}
		} //else System.out.println("�� �̻� �߰��� �� �����ϴ�.");
	}
	
	public void remove(String isbn) {
		boolean found = false;
		for(int i=0; i<MAX_SIZE; i++) {
			if(books[i]!=null && books[i].isbn.equals(isbn)) {
//				System.out.println(isbn + " �� å�� �����Ǿ����ϴ�");
				books[i] = null;
				found = true;
				size -= 1;
				break;
			}
		}
//		if(!found) System.out.println(isbn + " �� å�� ã�� ���߽��ϴ�.");		
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
//		System.out.println("�� " + size + "���� ������ �ֽ��ϴ�.");
		return existBook;
	}
	
	public Book searchByIsbn(String isbn) {
		for(Book b: books) {
			if(b!=null && b.isbn.equals(isbn)) {
//				System.out.println(isbn + " �� å�� ã�ҽ��ϴ�.");
				return b;
			}
		}
//		System.out.println(isbn + " �� å�� ã�� ���߽��ϴ�.");
		return null;
	}
	
}
