package com.inner;

// 4. anonymous class(무명 클래스)

abstract class Movie{
	abstract void play();
}

class MyMovie extends Movie{

	@Override
	void play() {
		System.out.println("외계인??");
	}
	
}

interface Game{
	void play();
}

public class MyTablet {
	
	public void start(Movie m) {
		m.play();
	}
	
	public void start(Game g) {
		g.play();
	}
	
	public static void main(String[] args) {
		MyTablet tab = new MyTablet();
		tab.start(new MyMovie());
		
		// 무명 클래스: 클래스 선언과 객체 생성을 한꺼번에 하는 객체
		// Movie를 상속받는 자식 클래스를 생성
		tab.start(new Movie() { // Movie 클래스를 상속받는 무명의 자식 클래스를 정의하고 생성까지 함.
			@Override
			void play() {
				System.out.println("탑건");
			}});
		
		tab.start(new Movie() {
			@Override
			void play() {
				System.out.println("명탐정 코난~할로윈의 신부🤍");
			}
		});
		
		tab.start(new Game() {
			@Override
			public void play() {
				System.out.println("🍁MapleStory🍁");
			}});
	}
	
}
