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
