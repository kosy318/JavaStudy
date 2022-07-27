### Exception conti.
- 상속관계<br>
부모가 예외를 던지면 자식은 throws를 안해도 된다.<br>
부모가 throws를 안했으면 자식도 throws를 할 수 없다.

## Inner Class (<-> top-level class)
<b>public, private, protected, default</b>
> top-level class : public, final, abstract, default
1. static class<br>
  외부 클래스를 생성하지 않고도 내부 클래스 생성해서 사용 가능<br>
  ```java
  Inner i = new Inner();
  ```
3. member class<br>
  내부 클래스를 사용(생성)하기 전에 먼저 외부 클래스가 생성되어 있어야함.<br>
  ```java
  Inner i = new Outer().new Inner();
  ```
5. local class - 잘 안씀<br>
  메소드 안에 선언되어 있음. 메소드 안에서만 사용 가능.
7. anonymous class(무명 클래스)<br>
  클래스 선언과 객체 생성을 한꺼번에 하는 객체<br>

## lambda
- jdk 1.8부터 생긴 기능
- 함수형 언어(ex. javaScript)에서부터 시작된 기능
- 함수(메소드)도 하나의 데이터 타입으로 인식
- 식별자(함수의 이름) 없이 함수를 정의하고 사용하는 방법<br>

#### 작성 규칙
1. 함수 이름, 리턴 타입은 적지 않음
2. 매개변수 타입은 생략 가능, 매개변수가 한개면 ()도 생략 가능
3. return문 생략 가능, 대신 expression(식)으로 대체 가능<br>
  return 키워드를 사용하는 경우는 {}를 꼭 쓸것
4. 함수의 body를 나타내는 {}는 body 안에 문장이 1개일 때 생략 가능
```java
(a, b)->{ 실행 문장들 }
```

## Stream (입출력x)
- jdk 1.8부터 생긴 기능
- lambda를 활용할 수 있는 기술
- Collection 객체(+배열, List, Set 종류)를 가지고 작업할 때 많이 사용
- Data의 흐름? Data의 묶음

#### 사용 순서
1. Stream 생성<br>
  ```java
  // 1. 배열로부터 스트림 생성
  Double[] point = {3.1, 4.6, 6.7, 5.6, 1.9};
  Stream<Double> st1 = Arrays.stream(point);

  // 2. Collection으로부터 스트림 생성
  List<String> names = new ArrayList(Arrays.asList("joyful", "Profession", "jdk", "java"));
  Stream<String> st2 = names.stream();

  // 3. 스트림 직접 생성
  Stream<Integer> st3 = Stream.of(100, 200, 300);
  Stream<String> st4 = Stream.of("white", "red", "blue");
  Stream<Circle> st5 = Stream.of(new Circle(8), new Circle(12));
  ```
2. 중간 연산(임시 작업) : 여러번 수행, filtering, sorting...
3. 최종 연산(결과) : 1번만 수행, 출력, 계산...<br>
  ```java
  List<String> names = new ArrayList<>(Arrays.asList("joyful", "Profession", "jdk", "java"));
  
  // filter() : 중간연산, count() : 최종연산
  long count = names.stream().filter(name -> name.contains("j")).count();
  System.out.println(count);
		
  // map() : 스트림 내의 요소들을 하나씩 특정 값으로 변환해 줌, pipeline
  names.stream()
			 .map(name -> name.concat(" o"))
			 .forEach(name -> System.out.println(name));
       
  List<Integer> ilist = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
  ilist.stream()
       .filter(i -> i > 3) // 3보다 큰 숫자 중
       .limit(3)		    	 // 3개까지만; 여기까지 중간연산
			 .forEach(i -> System.out.print(i + " ")); // 최종연산
  ```
