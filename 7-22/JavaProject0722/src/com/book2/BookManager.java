package com.book2;

import java.util.Arrays;

/** * 도서리스트를 배열로 유지하며 관리하는 클래스 : singleton type의 객체로 만듦 */
public class BookManager {
	
	private static Book[] list; /** * 관리할 도서 리스트 */
	private int size;	/** * 현재 등록된 도서 수 */
	private static int MAX_SIZE = 100; /** * 관리할 최대 도서 수 */
	
	private static BookManager instance;
	
	private BookManager() {
		list = new Book[MAX_SIZE];
	}
	
	public static BookManager getInstance() {
		if(instance == null)
			instance = new BookManager();
		return instance;
	}
	
	// 1. 도서추가
	public void add(Book book) {
		if(size < MAX_SIZE) {
			list[size] = book;
			size += 1;
//			System.out.println("책 정보가 추가되었습니다.");
		}
//		else System.out.println("더 이상 추가할 수 없습니다.");		
	}
	
	// 2. 도서삭제 : 삭제할 도서를 찾은 경우 해당 도서 위치에 저장된 제일 마지막 도서를 옮겨 놓음
	public void remove(String isbn) {
		boolean found = false;
		for(int i=0; i<MAX_SIZE; i++) {
			if(list[i]!=null && list[i].getIsbn().equals(isbn)) {
//				System.out.println(isbn + " 번 책이 삭제되었습니다");
				size -= 1;
				list[i] = list[size];
				list[size] = null;
				found = true;
				break;
			}
		}
//		if(!found) System.out.println(isbn + " 번 책을 찾지 못했습니다.");				
	}
	
	// 3. isbn기준 검색
	public Book findByIsbn(String isbn) {
		for(Book b: list) {
			if(b!=null && b.getIsbn().equals(isbn)) {
//				System.out.println(isbn + " 번 책을 찾았습니다.");
				return b;
			}
		}
//		System.out.println(isbn + " 번 책을 찾지 못했습니다.");
		return null;
	}
	
	// 4. 제목기준 검색: 제목을 포함하는 경우 검색
	public Book[] findByTitle(String title) {
		int cnt = 0;
		for(Book b: list) {
			if(b!=null && b.getTitle().contains(title))
				cnt++;
		}
		if(cnt == 0) {
	//		System.out.println(title + " 책을 찾지 못했습니다.");
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
	
	// 5. 잡지 검색
	public Magazine[] getMagazines() {
		int cnt = 0;
		for(Book b: list) {
			if(b!=null && b instanceof Magazine)
				cnt++;
		}
		if(cnt == 0) {
	//		System.out.println("잡지를 찾지 못했습니다.");
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
	
	// 6. 소설책 검색
	public Novel[] getNovels() {
		int cnt = 0;
		for(Book b: list) {
			if(b!=null && b instanceof Novel)
				cnt++;
		}
		if(cnt == 0) {
	//		System.out.println("소설을 찾지 못했습니다.");
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
	
	// 7. 저장된 모든 책 가격의 합
	public int getTotalPrice() {
		int total = 0;
		for(int i=0; i<size; i++) {
			if(list[i] != null) {
				total += list[i].getPrice();
			}
		}
		return total;
	}
	
	// 8. 저장된 모든 책 가격의 평균
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
//		System.out.println("총 " + size + "권의 정보가 있습니다.");
		return existBook;
	}
	
}
