## JavaProject0720\src
### com.object
- Member.java
07-19 생성자 복습
- ObjectTest.java
java 기본? class 연습<br>
Button & Frame & Checkbox
- StringTest.java
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
