package com.member;

// ������ ���� Ŭ����
public class MemberTest {
	
	public static void main(String[] args) {
		MemberManager manager = new MemberManager();
		
		Member m1 = new Member(1, "kim", "abc", 23);
		Member m2 = new Member(2, "ko", "def", 28);
		Member m3 = new Member(3, "k", "ghi", 22);
		
		if(manager.addMember(m1))
			System.out.println("�߰� : " + m1);
		else
			System.out.println("�ο��� ���� á���ϴ�.");
		if(manager.addMember(m2))
			System.out.println("�߰� : " + m2);
		else
			System.out.println("�ο��� ���� á���ϴ�.");
		if(manager.addMember(m3))
			System.out.println("�߰� : " + m3);
		else
			System.out.println("�ο��� ���� á���ϴ�.");
		
		System.out.println();
		Member found = manager.findByNum(2);
		if(found != null)
			System.out.println("2 �� ȸ���� ã�ҽ��ϴ�.");
		else
			System.out.println("2 �� ȸ���� ã�� ���߽��ϴ�.");
		
		System.out.println();
		Member[] exist = manager.getMembers();
		
		for(Member m : exist)
			System.out.println(m);
		
		System.out.println();
		if(manager.deleteMember(2))
			System.out.println("2 �� ȸ�� ������ �����Ǿ����ϴ�.");
		else
			System.out.println("2�� ȸ�� �� �������� �ʽ��ϴ�.");
		if(manager.deleteMember(3))
			System.out.println("3 �� ȸ�� ������ �����Ǿ����ϴ�.");
		else
			System.out.println("3�� ȸ�� �� �������� �ʽ��ϴ�.");

		m2.setNum(5);
		if(manager.addMember(m2))
			System.out.println("�߰� : " + m2);
		else
			System.out.println("�ο��� ���� á���ϴ�.");
		
		System.out.println();
		exist = manager.getMembers();
		
		for(Member m : exist)
			System.out.println(m);

		System.out.println();
		manager.addMember(new Member(111, "ko", "abc", 28));
		exist = manager.findByName("ko");

		for(Member m : exist) 
			System.out.println(m);
			
		System.out.println();
		exist = manager.findByAddress("abc");

		for(Member m : exist)
			System.out.println(m);

		System.out.println();
		manager.updateAddress(1, "ABC");
		
		System.out.println();
		exist = manager.getMembers();
		
		for(Member m : exist)
			System.out.println(m);
	}

}
