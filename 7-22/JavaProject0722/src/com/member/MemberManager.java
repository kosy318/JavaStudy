package com.member;

import java.util.Arrays;

// ȸ�������� ���ִ� Ŭ����(ȸ�� ���, ȸ�� ����, ȸ�� �˻�...)
public class MemberManager {
	
	// ȸ�� ������ ������ �迭
	Member[] members;
	
	// �ִ� ȸ�� ��
	int max = 10;
	// ���� �ο� ��
	int cnt = 0;
	
	// ������
	public MemberManager() {
		members = new Member[max];
	}
	
	// ȸ�� ���
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
	
	// ȸ�� ����
	public boolean deleteMember(int num) {
		for(int i=0; i<max; i++) {
			if(members[i]!=null && members[i].getNum()==num) {
				members[i] = null;
				cnt -= 1;
				return true;
			}
		}
		return false;
	}
	
	// ȸ�� �˻�
	public Member findByNum(int num) {
		for(Member m: members) {
			if(m!=null && m.getNum()==num) {
				return m;
			}
		}
		return null;
	}
	
	// ��� ȸ�� ����
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
		System.out.println("�� " + cnt + "���� ������ �ֽ��ϴ�.");
		return existMember;
	}
	
	// �̸����� �˻��ϴ� �޼ҵ�
	public Member[] findByName(String name) {
		int found = 0;
		Member[] foundMembers = new Member[max];
		for(Member m: members) {
			if(m!=null && m.getName().equals(name)) {
				foundMembers[found] = m;
				found += 1;
			}
		}
		if(found == 0)
			System.out.println(name + " ȸ���� ã�� ���߽��ϴ�.");
		else {
			System.out.println(name + " �̸��� " + found + " ���� ȸ���� ã�ҽ��ϴ�.");
			Member[] withoutNull = Arrays.copyOf(foundMembers, found);
			return withoutNull;
		}
		return null;
	}
	
	// �ּҷ� �˻��ϴ� �޼ҵ�
	public Member[] findByAddress(String address) {
		int found = 0;
		Member[] foundMembers = new Member[max];
		for(Member m: members) {
			if(m!=null && m.getAddress().equals(address)) {
				foundMembers[found] = m;
				found += 1;
			}
		}
		if(found == 0)
			System.out.println(address + " �ּҸ� ���� ȸ���� ã�� ���߽��ϴ�.");
		else {
			System.out.println(address + " �ּҸ� ���� " + found + " ���� ȸ���� ã�ҽ��ϴ�.");
			Member[] withoutNull = Arrays.copyOf(foundMembers, found);
			return withoutNull;
		}
		return null;
	}
	
	// ��ȣ �������� �ּҸ� �����ϴ� �޼ҵ�
	public void updateAddress(int num, String address) {
		boolean found = false;
		for(int i=0; i<max; i++) {
			if(members[i]!=null && members[i].getNum()==num) {
				System.out.println("�ּ� ���� �� : " + members[i]);
				members[i].setAddress(address);
				found = true;
				System.out.println("�ּ� ���� �� : " + members[i]);
				break;
			}
		}
		if(!found) System.out.println(num + " �� ȸ���� ã�� ���߽��ϴ�.");		
	}
		
}