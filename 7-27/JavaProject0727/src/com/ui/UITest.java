package com.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UITest {
	
	public static void main(String[] args) {
		// 창 생성
		JFrame f = new JFrame("UI TEst");
		
//		f.setLayout(new FlowLayout()); // f 안 내용물을 어떤 방식으로 배치할 건지 지정. 붙이는 순서대로 화면에 나타남
		f.setLayout(new BorderLayout()); // 전체 화면을 동서남북중앙의 5개 영역으로 나눠서 관리
		
		Font font = new Font("Consolas", Font.BOLD, 25);
		JLabel la = new JLabel("Cute Chat", JLabel.CENTER); // 문자열, 중앙정렬
		la.setFont(font);
		
		JButton ok = new JButton("ok");
		JButton cancel = new JButton("cancel");
		JTextField tf = new JTextField(20); // 한줄 입력칸
		JTextArea ta = new JTextArea(10, 20);
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta); // scroll pane 위로 text area가 올라가게됨 
		
//		f.add(ok);
//		f.add(cancel);
//		f.add(tf);
//		f.add(pane);
		f.add(la, "North");
		f.add(tf, "South");
		f.add(pane, "Center");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 눌렀을 때동작 지정. 프로그램 종료
		f.setSize(400, 500); // size
		f.setVisible(true);  // 실행 시 창이 눈에 보이도록 지정
		
		tf.requestFocus();
	}

}
