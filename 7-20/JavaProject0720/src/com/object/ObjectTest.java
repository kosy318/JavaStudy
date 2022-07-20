package com.object;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class ObjectTest {
	
	public static void main(String[] args) {
		Frame f = new Frame("Frame Test"); // window
		f.setLayout(new FlowLayout());
		
		Button b = new Button("ok");
		Button c = new Button("Cancel");
		Checkbox cb = new Checkbox("spring", true);
		Checkbox cb2 = new Checkbox("summer");
		
		f.add(b); // 창에 버튼을 붙임
		f.add(c); // 창에 버튼을 붙임
		
		f.add(cb);
		f.add(cb2);
		
		f.setSize(300, 300);
		f.setVisible(true); // 창이 눈에 보이게 함
	}

}
