package com.book;

public class BookTest {
	public static void main(String[] args) {
		BookManager bm = new BookManager();
		
		bm.add(new Book("21424", "Java Pro", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����"));
		bm.add(new Book("21425", "Java Pro2", "���ϳ�", "jaen.kr", 25000, "Java ����"));
		bm.add(new Book("35355", "�м�����", "�ҳ���", "jaen.kr", 30000, "SW �𵨸�"));
		
		System.out.println("*********************�������*********************");
		Book[] existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		String isbn = "21424";
		System.out.println("*********************������ȸ:" + isbn +"*********************");
		System.out.println(bm.searchByIsbn(isbn));
		
		System.out.println("*********************��������:" + isbn +"*********************");
		bm.remove(isbn);
		
		System.out.println("*********************�������*********************");
		existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
	}
}
