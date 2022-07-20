## JavaProject0720\src
### com.object
- Member.java<br>
07-19 생성자 복습
- ObjectTest.java<br>
java 기본? class 연습<br>
Button & Frame & Checkbox
- StringTest.java<br>
String class 연습

#### String
// s는 heap에 생기지x, Constant String Pool에 생성<br>
// 원본은 바꿀 수 x<br>
String s = "mylimeorange";<br>
// t는 heap에 생김<br>
String t = new String("mylimeorange");<br>
- == : 주소 비교<br>
- .equals() : 내용 비교

원본은 수정이 안되고 다른 String variable에 넣어줘야함<br>
메모리를 많이 차지하게됨<br>
StringBuffer나 StringBuilder를 사용하면 원본에서 수정이 가능함<br>
new 라는 키워드로 

#### static
- 객체들 간에 공유되는 유일한 값
- 객체 생성없이 클래스 이름으로 사용
- 멤버필드, 메소드, 블록에 사용
<br>

- StaticTest.java<br>
static 연습 + Math class 연습
- Circle.java<br>
Math class 연습

#### Wrapper Class
기본형 데이터를 참조형으로 변환시켜 주는 클래스들
- boolean -> Boolean
- byte -> Byte
- short -> Short
- int -> Integer<br>
Integer.MIN_VALUE;<br>
Integer.MAX_VALUE;<br>
Integer.parseInt("string");
- long -> Long
- float -> Float
- double -> Double
- char -> Char
<br>

- WrapperClassTest.java<br>
wrapper class 연습<br>
boxing : 기본 타입의 데이터를 래퍼 클래스의 인스턴스로 변환하는 과정<br>
unboxing : 래퍼 클래스의 인스턴스에 저장된 값을 다시 기본 타입의 데이터로 꺼내는 과정

### com.member
array + class 응용
- Member.java
- MemberManager.java
- MemberTest.java
