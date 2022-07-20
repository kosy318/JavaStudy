package com.member;

import java.util.Arrays;

// 회원관리를 해주는 클래스(회원 등록, 회원 삭제, 회원 검색...)
public class MemberManager {
	
	// 회원 정보를 저장할 배열
	Member[] members;
	
	// 최대 회원 수
	int max = 10;
	// 현재 인원 수
	int cnt = 0;
	
	// 생성자
	public MemberManager() {
		members = new Member[max];
	}
	
	// 회원 등록
	public boolean addMember(Member newMember) {
		if(cnt < max) {
			for(int i=0; i<max; i++) {
				if(members[i] == null) {
					members[i] = newMember;
					cnt += 1;
					return true;
				}
			}
		}
		return false;
	}
	
	// 회원 삭제
	public boolean deleteMember(int num) {
		boolean found = false;
		for(int i=0; i<max; i++) {
			if(members[i]!=null && members[i].num==num) {
				members[i] = null;
				found = true;
				cnt -= 1;
				return true;
			}
		}
		return false;
	}
	
	// 회원 검색
	public Member findByNum(int num) {
		for(Member m: members) {
			if(m!=null && m.num==num) {
				return m;
			}
		}
		return null;
	}
	
	// 모든 회원 정보
	public Member[] getMembers() {
		Member[] existMember = new Member[cnt];
		int idx = 0;
		for(Member m : members) {
			if(m != null) {
				existMember[idx] = m;
				idx += 1;
			}
			if(idx == cnt) break;
		}
		System.out.println("총 " + cnt + "명의 정보가 있습니다.");
		return existMember;
	}
	
	// 이름으로 검색하는 메소드
	public Member[] findByName(String name) {
		int found = 0;
		Member[] foundMembers = new Member[max];
		for(Member m: members) {
			if(m!=null && m.name.equals(name)) {
				foundMembers[found] = m;
				found += 1;
			}
		}
		if(found == 0)
			System.out.println(name + " 회원을 찾지 못했습니다.");
		else {
			System.out.println(name + " 이름의 " + found + " 명의 회원을 찾았습니다.");
			Member[] withoutNull = Arrays.copyOf(foundMembers, found);
			return withoutNull;
		}
		return null;
	}
	
	// 주소로 검색하는 메소드
	public Member[] findByAddress(String address) {
		int found = 0;
		Member[] foundMembers = new Member[max];
		for(Member m: members) {
			if(m!=null && m.address.equals(address)) {
				foundMembers[found] = m;
				found += 1;
			}
		}
		if(found == 0)
			System.out.println(address + " 주소를 가진 회원을 찾지 못했습니다.");
		else {
			System.out.println(address + " 주소를 가진 " + found + " 명의 회원을 찾았습니다.");
			Member[] withoutNull = Arrays.copyOf(foundMembers, found);
			return withoutNull;
		}
		return null;
	}
	
	// 번호 기준으로 주소를 수정하는 메소드
	public void updateAddress(int num, String address) {
		boolean found = false;
		for(int i=0; i<max; i++) {
			if(members[i]!=null && members[i].num==num) {
				System.out.println("주소 수정 전 : " + members[i]);
				members[i].address = address;
				found = true;
				System.out.println("주소 수정 후 : " + members[i]);
				break;
			}
		}
		if(!found) System.out.println(num + " 번 회원을 찾지 못했습니다.");		
	}
		
}