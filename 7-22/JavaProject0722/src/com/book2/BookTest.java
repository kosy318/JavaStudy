package com.book2;

public class BookTest {
	public static void main(String[] args) {
		BookManager bm = BookManager.getInstance();
		
		bm.add(new Magazine("34655", "Java ����1", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����", 2022, 7));
		bm.add(new Novel("35355", "�м�����", "�ҳ���", "jaen.kr", 30000, "SW �𵨸�", "����"));
		bm.add(new Magazine("14212", "c++ ����2", "���ϳ�", "jaen.kr", 25000, "Java ����", 2022, 8));
		bm.add(new Novel("12323", "c++ �Ҽ�1", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����", "����"));
		bm.add(new Magazine("21424", "Java Pro", "���ϳ�", "jaen.kr", 15000, "Java �⺻ ����", 2021, 1));
		bm.add(new Novel("12345", "Java �Ҽ�2", "���ϳ�", "jaen.kr", 25000, "Java ����", "����"));
		bm.add(new Magazine("21425", "Java Pro2", "���ϳ�", "jaen.kr", 25000, "Java ����", 2022, 4));
		
		System.out.println("*********************�������*********************");
		Book[] existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		String isbn = "21424";
		System.out.println("*********************������ȸ:" + isbn +"*********************");
		System.out.println(bm.findByIsbn(isbn));
		
		System.out.println("*********************��������:" + isbn +"*********************");
		bm.remove(isbn);
		
		System.out.println("*********************�������*********************");
		existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************Magazine ���*********************");
		existBooks = bm.getMagazines();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************Novel ���*********************");
		existBooks = bm.getNovels();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************c++�� ���� �����ϴ� å*********************");
		existBooks = bm.findByTitle("c++");
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println("*********************�������*********************");
		existBooks = bm.getList();
		for(Book b : existBooks)
			System.out.println(b);
		
		System.out.println();
		System.out.println("total price : " + bm.getTotalPrice() + ", price average : " + bm.getPriceAverage());
	}
}
