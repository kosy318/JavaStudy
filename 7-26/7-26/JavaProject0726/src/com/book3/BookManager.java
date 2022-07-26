package com.book3;

import java.util.ArrayList;

/** * 도서리스트를 ArrayList로 유지하며 관리하는 클래스 : singleton type의 객체로 만듦 */
public class BookManager implements IBookManager {
	
	private static ArrayList<Book> list; 	/** * 관리할 도서 리스트 */
	
	private static BookManager instance;
	
	private BookManager() {
		list = new ArrayList<>();
	}
	
	public static BookManager getInstance() {
		if(instance == null)
			instance = new BookManager();
		return instance;
	}
	
	// 1. 도서추가
	public void add(Book book) {
		// 동일한 isbn의 경우 체크!!! -> HashMap 쓰면 안되나?
		list.add(book);
//		System.out.println("책 정보가 추가되었습니다.");
	}
	
	// 2. 도서삭제 : 삭제할 도서를 찾은 경우 해당 도서 위치에 저장된 제일 마지막 도서를 옮겨 놓음
	public void remove(String isbn) {
		boolean found = false;
		for(Book book : list) {
			if(book.getIsbn().equals(isbn)) {
//				System.out.println(isbn + " 번 책이 삭제되었습니다");
				list.remove(book);
				found = true;
				break;
			}
		}
//		if(!found) System.out.println(isbn + " 번 책을 찾지 못했습니다.");				
	}
	
	// 3. isbn기준 검색
	public Book findByIsbn(String isbn) {
		for(Book book: list) {
			if(book.getIsbn().equals(isbn)) {
//				System.out.println(isbn + " 번 책을 찾았습니다.");
				return book;
			}
		}
//		System.out.println(isbn + " 번 책을 찾지 못했습니다.");
		return null;
	}
	
	// 4. 제목기준 검색: 제목을 포함하는 경우 검색
	public ArrayList<Book> findByTitle(String title) {		
		ArrayList<Book> foundBooks = new ArrayList<>();
		for(Book book: list) {
			if(book.getTitle().contains(title)) {
				foundBooks.add(book);
			}
		}
		if(foundBooks.size() == 0) {
			System.out.println(title + "을 포함하는 제목을 가진 책이 없습니다.");
			return null;
		}
		return foundBooks;
	}
	
	// 5. 잡지 검색
	public ArrayList<Magazine> getMagazines() {
		ArrayList<Magazine> foundMagazine = new ArrayList<>();
		for(Book book: list) {
			if(book instanceof Magazine) {
				foundMagazine.add((Magazine)book);
			}
		}
		if(foundMagazine.size() == 0) {
			System.out.println("잡지를 찾지 못했습니다.");
			return null;
		}
		return foundMagazine;
	}
	
	// 6. 소설책 검색
	public ArrayList<Novel> getNovels() {
		ArrayList<Novel> foundNovel = new ArrayList<>();
		for(Book book: list) {
			if(book instanceof Novel) {
				foundNovel.add((Novel)book);
			}
		}
		if(foundNovel.size() == 0) {
			System.out.println("소설을 찾지 못했습니다.");
			return null;
		}
		return foundNovel;
	}
	
	// 7. 저장된 모든 책 가격의 합
	public int getTotalPrice() {
		int total = 0;
		for(Book book : list) {
			total += book.getPrice();
		}
		return total;
	}
	
	// 8. 저장된 모든 책 가격의 평균
	public double getPriceAverage() {
		return this.getTotalPrice()/(double)list.size();
	}

	@Override
	public ArrayList<Magazine> findMagazineByYear(int year) {
		ArrayList<Magazine> foundMagazine = new ArrayList<>();
		for(Book book : list) {
			if(book instanceof Magazine && ((Magazine) book).getYear() == year) {
				foundMagazine.add((Magazine)book);
			}
		}
		if(foundMagazine.size() == 0) {
			System.out.println(year + "년도 잡지가 존재하지 않습니다.");
			return null;
		}
		return foundMagazine;
	}

	@Override
	public ArrayList<Book> findByPrice(int price1, int price2) {
		if(price1 > price2) System.out.println(price1 + "의 값이 " + price2 + "보다 큽니다.\n다시 입력해주세요.");
		ArrayList<Book> foundBook = new ArrayList<>();
		for(Book book : list) {
			if(book.getPrice() >= price1 && book.getPrice() <= price2) {
				foundBook.add(book);
			}
		}
		if(foundBook.size() == 0) {
			System.out.println(price1 + "원과 " + price2 + "원 사이의 책이  존재하지 않습니다.");
			return null;
		}
		return foundBook;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) {
		ArrayList<Book> foundBook = new ArrayList<>();
		for(Book book : list) {
			if(book.getPublisher().equals(publisher)) {
				foundBook.add(book);
			}
		}
		if(foundBook.size() == 0) {
			System.out.println(publisher + "에서 출판한 책이  존재하지 않습니다.");
			return null;
		}
		return foundBook;
	}
	
	public ArrayList<Book> getList() {
		System.out.println("총 " + list.size() + "권의 정보가 있습니다.");
		return list;
	}
	
}