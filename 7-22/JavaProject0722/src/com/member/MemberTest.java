package com.member;

// 실행을 위한 클래스
public class MemberTest {
	
	public static void main(String[] args) {
		MemberManager manager = new MemberManager();
		
		Member m1 = new Member(1, "kim", "abc", 23);
		Member m2 = new Member(2, "ko", "def", 28);
		Member m3 = new Member(3, "k", "ghi", 22);
		
		if(manager.addMember(m1))
			System.out.println("추가 : " + m1);
		else
			System.out.println("인원이 전부 찼습니다.");
		if(manager.addMember(m2))
			System.out.println("추가 : " + m2);
		else
			System.out.println("인원이 전부 찼습니다.");
		if(manager.addMember(m3))
			System.out.println("추가 : " + m3);
		else
			System.out.println("인원이 전부 찼습니다.");
		
		System.out.println();
		Member found = manager.findByNum(2);
		if(found != null)
			System.out.println("2 번 회원을 찾았습니다.");
		else
			System.out.println("2 번 회원을 찾지 못했습니다.");
		
		System.out.println();
		Member[] exist = manager.getMembers();
		
		for(Member m : exist)
			System.out.println(m);
		
		System.out.println();
		if(manager.deleteMember(2))
			System.out.println("2 번 회원 정보가 삭제되었습니다.");
		else
			System.out.println("2번 회원 이 존재하지 않습니다.");
		if(manager.deleteMember(3))
			System.out.println("3 번 회원 정보가 삭제되었습니다.");
		else
			System.out.println("3번 회원 이 존재하지 않습니다.");

		m2.setNum(5);
		if(manager.addMember(m2))
			System.out.println("추가 : " + m2);
		else
			System.out.println("인원이 전부 찼습니다.");
		
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
