sts/eclipse 사용법
ctrl+shift+O : import

## JavaProject0719\src
### com.array
- ArrayMulti.java<br>
배열 선언 및 접근
- ArrayMulti2D.java<br>
2D배열 선언 및 입력을 받아 4방 접근
- ArrayMulti2D2.java<br>
2D배열 선언 및 모든 요소의 4방 접근

#### 입력 받기
- 키보드 입력<br>
Scanner sc = new Scanner(System.in);
- 변수 입력<br>
Scanner sc = new Scanner(src);
<br>

- int 입력<br>
int i = sc.nextInt();
- char 입력<br>
sc.next() : 공백이나 줄바꿈같은걸로 구분됨<br>
char ch = sc.next().charAt(0);

### com.method
#### OOP
method == function<br>
수식어(순서 바껴도 됨) 리턴타입 메소드이름( parameter ) { method body }<br>

- MethodTest.java<br>
자바 함수 만들기 연습

#### class + object
class : data + method로 이루어진 구조. Template과 같음<br>
object : class로부터 생성된 실체(= instance), 키워드 new로 객체 생성
- object 사용 순서
1. class 설계 // class Test{}
2. 객체 생성 // Test t = new Test();
3. 객체 사용 // t.go();

### com.object
- Car.java, Circle.java, Rect.java<br>
자바 클래스 만들기 연습

#### 생성자
1. 클래스 이름과 동일한 이름의 함수
2. 리턴 타입은 적지 않음
3. 객체의 생성 시에 호출됨

<br>

![image](https://user-images.githubusercontent.com/77595685/179697871-a86eb91a-f9ea-423d-9e96-a3545526b2dd.png)

1. heap에 객체를 위한 공간 할당
2. instance(객체) 변수 자동 초기화
3. instance(객체) 변수 명시적 초기화 : 사용자가 따로 준 값으로 초기화
4. 생성자 호출
5. 참조값 반환
