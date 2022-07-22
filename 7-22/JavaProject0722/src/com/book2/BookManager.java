package com.book2;

import java.util.Arrays;

/** * ��������Ʈ�� �迭�� �����ϸ� �����ϴ� Ŭ���� : singleton type�� ��ü�� ���� */
public class BookManager {
	
	private static Book[] list; /** * ������ ���� ����Ʈ */
	private int size;	/** * ���� ��ϵ� ���� �� */
	private static int MAX_SIZE = 100; /** * ������ �ִ� ���� �� */
	
	private static BookManager instance;
	
	private BookManager() {
		list = new Book[MAX_SIZE];
	}
	
	public static BookManager getInstance() {
		if(instance == null)
			instance = new BookManager();
		return instance;
	}
	
	// 1. �����߰�
	public void add(Book book) {
		if(size < MAX_SIZE) {
			list[size] = book;
			size += 1;
//			System.out.println("å ������ �߰��Ǿ����ϴ�.");
		}
//		else System.out.println("�� �̻� �߰��� �� �����ϴ�.");		
	}
	
	// 2. �������� : ������ ������ ã�� ��� �ش� ���� ��ġ�� ����� ���� ������ ������ �Ű� ����
	public void remove(String isbn) {
		boolean found = false;
		for(int i=0; i<MAX_SIZE; i++) {
			if(list[i]!=null && list[i].getIsbn().equals(isbn)) {
//				System.out.println(isbn + " �� å�� �����Ǿ����ϴ�");
				size -= 1;
				list[i] = list[size];
				list[size] = null;
				found = true;
				break;
			}
		}
//		if(!found) System.out.println(isbn + " �� å�� ã�� ���߽��ϴ�.");				
	}
	
	// 3. isbn���� �˻�
	public Book findByIsbn(String isbn) {
		for(Book b: list) {
			if(b!=null && b.getIsbn().equals(isbn)) {
//				System.out.println(isbn + " �� å�� ã�ҽ��ϴ�.");
				return b;
			}
		}
//		System.out.println(isbn + " �� å�� ã�� ���߽��ϴ�.");
		return null;
	}
	
	// 4. ������� �˻�: ������ �����ϴ� ��� �˻�
	public Book[] findByTitle(String title) {
		int cnt = 0;
		for(Book b: list) {
			if(b!=null && b.getTitle().contains(title))
				cnt++;
		}
		if(cnt == 0) {
	//		System.out.println(title + " å�� ã�� ���߽��ϴ�.");
			return null;
		}
		
		Book[] foundBooks = new Book[cnt];
		int idx = 0;
		for(Book b: list) {
			if(b!=null && b.getTitle().contains(title)) {
				foundBooks[idx] = b;
				idx++;
			}
			if(idx == cnt) break;
		}
		return foundBooks;
	}
	
	// 5. ���� �˻�
	public Magazine[] getMagazines() {
		int cnt = 0;
		for(Book b: list) {
			if(b!=null && b instanceof Magazine)
				cnt++;
		}
		if(cnt == 0) {
	//		System.out.println("������ ã�� ���߽��ϴ�.");
			return null;
		}
		
		Magazine[] foundMagazine = new Magazine[cnt];
		int idx = 0;
		for(Book b: list) {
			if(b!=null && b instanceof Magazine) {
				foundMagazine[idx] = (Magazine) b;
				idx++;
			}
			if(idx == cnt) break;
		}
		return foundMagazine;
	}
	
	// 6. �Ҽ�å �˻�
	public Novel[] getNovels() {
		int cnt = 0;
		for(Book b: list) {
			if(b!=null && b instanceof Novel)
				cnt++;
		}
		if(cnt == 0) {
	//		System.out.println("�Ҽ��� ã�� ���߽��ϴ�.");
			return null;
		}
		
		Novel[] foundNovel = new Novel[cnt];
		int idx = 0;
		for(Book b: list) {
			if(b!=null && b instanceof Novel) {
				foundNovel[idx] = (Novel) b;
				idx++;
			}
			if(idx == cnt) break;
		}
		return foundNovel;
	}
	
	// 7. ����� ��� å ������ ��
	public int getTotalPrice() {
		int total = 0;
		for(int i=0; i<size; i++) {
			if(list[i] != null) {
				total += list[i].getPrice();
			}
		}
		return total;
	}
	
	// 8. ����� ��� å ������ ���
	public double getPriceAverage() {
		return this.getTotalPrice()/(double)size;
	}

	public Book[] getList() {
		Book[] existBook = new Book[size];
		int idx = 0;
		for(Book b : list) {
			if(b != null) {
				existBook[idx] = b;
				idx += 1;
			}
			if(idx == size) break;
		}
//		System.out.println("�� " + size + "���� ������ �ֽ��ϴ�.");
		return existBook;
	}
	
}
