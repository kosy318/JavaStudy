sts/eclipse 사용법
ctrl+shift+O : import

## JavaProject0719\src
### com.array
- ArrayMulti.java
배열 선언 및 접근
- ArrayMulti2D.java
2D배열 선언 및 입력을 받아 4방 접근
- ArrayMulti2D2.java
2D배열 선언 및 모든 요소의 4방 접근

#### 입력 받기
- 키보드 입력
Scanner sc = new Scanner(System.in);
- 변수 입력
Scanner sc = new Scanner(src);
<br>
- int 입력
int i = sc.nextInt();
- char 입력
sc.next() : 공백이나 줄바꿈같은걸로 구분됨
char ch = sc.next().charAt(0);

### com.method
#### OOP
method == function<br>
수식어(순서 바껴도 됨) 리턴타입 메소드이름( parameter ) { method body }<br>

- MethodTest.java
자바 함수 만들기 연습

#### class + object
class : data + method로 이루어진 구조. Template과 같음<br>
object : class로부터 생성된 실체(= instance), 키워드 new로 객체 생성
- object 사용 순서
1. class 설계 // class Test{}
2. 객체 생성 // Test t = new Test();
3. 객체 사용 // t.go();
