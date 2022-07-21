eclipse.ini(우린 sts를 사용해서 sts.ini) 파일 내에 -Dfile.encoding=UTF-8 추가<br>
<br>
### Variable이란?
자료를 저장하기 위한 메모리 공간으로 타입에 따라 크기가 달라짐<br>
메모리 공간에 값을 할당 후 사용

### Type이란?
데이터의 종류
- 기본형(primitive type) : 미리 정해진 크기의 Memory Size로 표현, 변수 자체에 값 저장
- 참조형(reference type) : 크기가 미리 정해질 수 없는 데이터의 표현, 변수에는 실제 값을 참조할 수 있는 주소만 저장


### 기본형(primitive type)의 크기
- 논리형 : boolean
- 정수형 : byte(8bit), short(16bit), int(32bit), long(64bit, 뒤에 l이나 L을 붙여 명시한다)
- 실수형 : float(32bit, 뒤에 f를 붙여 명시한다), double(64bit)
- 문자형 : char(16bit)<br>

- 정수 계산 시 overflow 주의
- 필요한 수의 크기를 고려해서 int 또는 long등 타입 선택
<br>

실수의 연산은 정확하지 않다.
- 유효 자리수를 이용한 반올림 처리

### 형변환(Type casting)이란?
변수의 타입을 다른 타입으로 변환하는 것<br>
primitive는 primitive끼리, reference는 reference끼리 형 변환 가능<br>
- boolean은 다른 기본 타입과 호환되지 않음
- 기본 타입과 참조형의 형 변환을 위해서 Wrapper 클래스 사용

#### 형 변환 방법
- 형 변환 연산자(괄호) 사용

### 기본형의 형 변환 진행
- 묵시적 형 변환(promotion) : 작은 데이터 타입에서 큰 데이터 타입으로 변환, 데이터가 손실되지 않음
- 명시적 형 변환 : 큰 데이터 타입에서 자긍ㄴ 데이터 타입으로 변환, 데이터가 손실됨<br>
<br>
- 값의 크기, 타입의 크기가 아닌 타입의 표현 범위가 커지는 방향으로 할당할 경우는 묵시적 형변환 발생
- 명시적 형 변환은 값 손실이 발생할 수 있으므로 프로그래머 책임하에 형 변환 진행
- 묵시적 형 변환은 자료의 손실 걱정이 없으므로 JVM이 서비스 해줌

### 연산자란?
어떤 기능을 수행하는 기호<br>
연산자 종류와 우선순위 및 결합 방향<br>
<br>
```java
byte b1 = 10;
byte b2 = 20;
// byte b3 = b1 + b2;
// Type mismatch: cannot convert from int to byte
byte b3 = (byte)(b1 + b2);

int i1 = 10;
long l1 = 20;
// int i2 = i1 + l1;
// Type mismatch: cannot convert from long to int
int i2 = i1 + (int)l1;

// float f1 = 10.0;
// Type mismatch: cannot convert from double to float
float f1 = 10.0f;

// float f2 = f1 + 20.0;
/* Multiple markers at this line
-Type mismatch: cannot convert from double to float
-f1 cannot be resolved to a variable */
double f2 = f1 + 20.0;
```

- 산술 이항 연산자는 연산 전에 피 연산자의 타입을 일치시킨다.
- 피연산자의 크기가 4byte(int) 미만이면 int로 변경한 후 연산 진행
- 두 개의 피연산자 중 큰 타입으로 형 변환 후 연산 진행<br>
<br>

### 조건문(Conditional Statement)
- if(논리형, 비교식, Method call)
- switch(정수호환, Enum, Class Object[Byte, short, Character, Integer, String], Method Call)

### 반복문 for 구성
for(변수 초기화; 반복 조건; 증감식){ 실행문 }<br>

### for vs while
#### for
- 초기값, 조건식, 증감식의 위치가 명확
- 반복의 회수가 명확한 경우
- index의 증감 활용

#### while
- 반복의 회수가 불명확한 경우
- index보다는 break, continue 활용

### 배열
동일한 타입의 변수를 여러 개 사용하면..<br>
- 변수의 수 증가
- 코드의 길이 증가<br>
<br>
- 반복문 적용 불가
- 변수의 수가 동적으로 결정될 경우, 사용 불가<br>
<br>
배열(Array)로 동일 타입 변수 묶어서 사용하기
- 배열이란? 동일한 타입의 데이터 0개 이상을 하나의 연속된 메모리 공간에서 관리하는 것
- 요소에 접근하는 속도가 매우 빠르다
- 한번 생성하면 크기 변경 불가

### Array 만들기#1
타입[] 변수명; 또는 타입 변수명[]<br>
reference 타입

### 배열의 생성과 초기화
생성<br>
new keyword와 함께 저장하려는 데이터 타입 및 크기 지정: new data_type[length]<br>
- new int[3]; int 타입의 자료 3개를 저장할 수 있는 배열을 메모리에 생성
- points = new int[3]; 생성된 배열을 points라는 변수에 할당
- points는 메모리에 있는 배열을 가리키는 reference 타입 변수<br>
배열 요소의 초기화
- 배열의 생성과 동시에 저장 대상 자료형에 대한 기본값으로 default 초기화 진행
- boolean: false, char: '\u0000'(공백문자), byte/short/int: 0, long: 0L, float: 0.0f, double: 0.0, 참조형 변수: null(아무것도 참조하지 않음)

### 배열의 사용
배열은 index 번호를 가지고 각 요소에 접근 가능<br>
- index 번호는 0부터 시작
- 배열의 길이: 배열이름.length로 배열의 크기 조회 가능

### Array 출력을 편리하기
for문을 통한 출력대신 Arrays.toString()<br>

### Array 만들기#2
생성과 동시에 할당한 값으로 초기화<br>
- int[] b = new int[] {1, 3, 5, 6, 8};
- int[] c = {1, 3, 5, 6, 8};<br>

### 선언과 생성을 따로 처리할 경우 초기화 주의
- int[] points; points = {1, 3, 5, 6, 8}; // 컴파일 오류
- int[] points; points = new int[] {1, 3, 5, 6, 8}; // 선언할 때는 배열의 크기를 알 수 없을 때

### 배열의 생성과 메모리 사용 과정
- int[] points = new int[3];
- 배열 선언: int[] points
- 배열 생성: new int[3]; int 타입의 데이터 3개를 담을 수 있는 메모리 공간 확보
- 메모리에 연속된 공간 차지 -> 크기 변경 불가!
- Type에 대한 default 초기화
- 참조 값 할당: points = new int[3]; 배열의 주소를 변수에 할당하여 참조하게 함
- 요소에 할당: points[0]=1; points[1]='A';

### for-each with Array
- 가독성이 개선된 반복문으로, 배열 및 Collections에서 사용
- index 대신 직접요소(element)에 접근하는 변수를 제공(naturally read only, copied value)
- 사용 : int intArray [] = {1, 3, 5, 7, 9}; for(int x: intArray){ System.out.println(x);}

### Array is Immutable
- 배열은 최초 메모리 할당 이후 변경할 수 없음
- 개별 요소는 다른 값으로 변경이 가능하나, 요소를 추가하거나 삭제할 수는 없음<br>
<br>
더이상 참조하지 않는 메모리 : garbage, GC가 청소함

### api 제공하는 배열 복사 method
System.arrayCopy<br>
Arrays.copyOf

### 2차원 Array 만들기
int Type 기준으로 4x3 배열(Array) 만들기
- 선언: int[][] intArray; int intArray[][]; int[] intArray[];
- 생성: intArray = new int[4][3];
- 할당: intArray[0][2] = 3;<br>
<br>
int Type 기준으로 4x3 배열(Array)과 값을 동시에 만들기<br>
- 선언, 생성, 할당 동시에
- int[][] intArray = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};<br>
<br>
int Type 기준으로 4x? 배열(Array) 만들기<br>
- 1,2차 선언/ 1차 생성
- int[][] intArray = new int[4][];
- 1차 Array만 생성 후, 필요에 따라 2차 배열을 생성함<br>
intArray[0] = new int[3];<br>
intArray[1] = new int[2];<br>
intArray[2] = new int[] {1, 2, 3};

### 객체지향 프로그래밍이란? - Object Oriented Programming
객체란? : 주체가 아닌 것, 주체가 활용하는 것<br>
- 우리 주변에 있는 모든 것으로 프로그래밍의 대상 : 사물, 개념, 논리...<br>
객체지향 프로그래밍<br>
- 주변의 많은 것들을 객체화 해서 프로그래밍 하는 것
- 객체지향은 객체를 많이 만드는 것을 추천한다?

### 객체지향 프로그래밍의 장점
블록 형태의 모듈화된 프로그래밍<br>
- 신뢰성 높은 프로그래밍이 가능하다
- 추가/수정/삭제가 용이하다
- 재사용성이 높다

### 현실 세계 객체, 클래스, 프로그램의 객체(instance, object)의 관계
현실의 객체가 갖는 속성과 기능은 추상화(abstraction)되어 클래스에 정의된다!<br>
클래스는 구체화되어 프로그램의 객체(instance, object)가 된다.<br>
현실의 객체는 우리가 만지고 느낄 수 있는 것 -> 실생활에 구체화 되어있는 내용<br>
- 이런 객체를 필요할 때마다 매번 처음부터 새로 만들어야한다면?
- 실생활에서는 붕어빵 틀, 설계도(blueprint) 사용
- 설계도는 제품을 만들기 위해 꼭 필요하지만 이를 사용하지는 않고 설계도로 만든 제품 사용
- 설계도는 하나의 종류(Type)가 되고 설계도를 통해 나온 제품을 객체라고 부르며 주체가 사용<br>
<br>
- 현실의 객체가 갖는 속성과 기능은 추상화(abstraction) 되어 클래스에 정의된다!
- 클래스는 구체화되어 프로그램의 객체(instance, object)가 된다.

### 프로그램의 클래스와 객체
#### 클래스
- 객체를 정의해 놓은 것 즉 객체의 설계도, 틀
- 클래스는 직접 사용할 수 없고 직접 사용되는 객체를 만들기 위한 틀을 제공할 뿐
#### 객체(instance, object)
- 클래스를 데이터 타입으로 메모리에 생성된 것

### 객체 생성과 메모리
#### JVM의 메모리 구조
- class area
	- 클래스 원형 로딩
		- Field 정보
		- Method 정보
		- 타입 정보
		- 상수 풀
- method stack
	- 메서드들의 실행 공간
		- thread 별로 별도 관리
		- 메서드 호출 순서대로 쌓이는 구조
		- 메서드 프레임에 로컬변수도 쌓이는 구조
		- 로컬변수는 선언도니 영역을 벗어나면 삭제
- heap
	- 객체를 저장하기 위한 영역
		- thread에 의해 공유
		- 생성된 객체는 프로그래머가 삭제할 수 없고 GC만이 제어 가능

### 변수의 종류
#### 타입에 따른 분류
- Primitive Type variable : 기본 8가지 type의 변수
- Reference Type variable : 나머지 모든 것(객체 참조)
#### 선언 위치에 다른 분류
- 멤버 변수 : 클래스 멤버 변수(클래스 영역, static keyword), 인스턴스 멤버 변수(클래스 영역)
- 지역 변수 : 지역 변수(함수 내부), 파라미터 변수(함수 선언부)

### 인스턴스 멤버 변수의 특징
- 선언 위치 : 클래스 {}영역에 선언<br>
```java
public class Person{
	String name;
	int age;
}
```
- 변수의 생성 : 객체가 만들어질 때 객체 별로 생성됨<br>
  - 생성 메모리 영역 : heap
- 변수의 초기화 : 타입 별로 default 초기화<br>
- 변수에의 접근 : 객체 생성 후(메모리에 올린 후) 객체 이름(소속)으로 접근<br>
  - 객체를 만들 때마다 객체 별로 생성 -> 객체마다 고유한 상태(변수 값) 유지
- 소멸 시점 : Garbage Collector에 의해 객체가 없어질 때 프로그래머가 명시적으로 소멸시킬 수 없음

### 클래스 멤버 변수의 특징(static 멤버)
- 선언 위치 : 클래스{}영역에 선언되며 static 키워드를 붙임<br>
```java
public class Person{
	static String scientificName = "Homo Sapiens";
	String name;
}
```
- 변수의 생성 : 클래스 영역에 클래스 로딩 시 메모리 등록
  - 개별 객체의 생성과 무관
  - 모든 객체가 공유하게 됨(공유 변수라고도 불림)
- 변수의 초기화 : 타입 별로 default 초기화
- 변수에의 접근 : 객체 생성과 무관하게 클래스 이름(소속)으로 접근
  - 객체를 생성하고 객체 이름으로 접근도 가능하나 static에 부합한 표현은 아님
- 소멸 시점 : 프로그램 종료 시
- 정적 : 거의 바뀌지 않음

### 위치에 따른 변수의 종류
지역 변수 & 파라미터 변수<br>
- 선언 위치 : 클래스 영역의 {}이외의 모든 중괄호 안에 선언되는 변수들
  - 메서드, 생성자, 초기화 블록<br>
```java
void call(String to){	// 파라미터 변수
	String beep = "띠";	// 로컬 변수

	for(int i=0; i<3; i++){	// 로컬 변수
		System.out.println(beep);
	}
}
```
- 변수의 생성 : 선언된 라인이 실행될 때
  - 생성 메모리 영역 : thread 별로 생성된 stack 영역
- 변수의 초기화 : 사용하기 전 명시적 초기화 필요
- 변수에의 접근 : 외부에서는 접근이 불가하므로 소속 불필요
  - 내부에서는 이름에 바로 접근
- 소멸 시점 : 선언된 영역인 {}을 벗어날 때

### 메서드정의와 필요성
#### 메서드란?
- 현실의 객체가 하는 동작을 프로그래밍화
- 어떤 작업을 수행하는 명령문의 집합

#### 메서드를 작성하는 이유
- 반복적으로 사용되는 코드의 중복 방지(DRY: Don't Repeat Yourself!, WET: We Enjoy Typing or Write Everything Twice)
- 코드의 양을 줄일 수 있고 유지 보수가 용이함

### 선언부
- 리턴타입
  - 호출 결과 호출한 곳으로 반환되는 값의 타입으로 아무것도 리턴하지 않을 경우 void
  - 결과를 받을 때 묵시적 형 변환 적용
  - 리턴 타입은 하나만 적용 가능
- 메서드 이름 : 메서드가 수행하는 작업을 쉽게 파악하도록 의미 있는 이름 사용
- 파라미터 목록
  - 메서드 호출 시점에 넘겨줘야 하는 변수들로 넘겨줄 정보가 없을 경우 생략 가능
  - 파라미터 전달 시 묵시적 형변환 적용

### Variable arguments
메서드 선언 시 몇 개의 인자가 들어올 지 예상할 수 없을 경우(또는 가변적)<br>
- 배열 타입을 선언할 수 있으나->베서드 호출 전 배열을 생성, 초기화 해야 하는 번거로움
- ...을 이용해 파라미터를 선언하면 호출 시 넘겨준 값의 개수에 따라 자동으로 배열 생성 및 초기화<br>
```java
public static void main(String[] args){
	VariableTest vt = new VariableTest();
	vt.variableArgs(1, 2, 3);
	vt.variableArgs(1, 2, 3, 4, 5);
	vt.variableArgs(1, 2);
}
public void variableArgs(int... params){
	int sum = 0;
	for(int i: params){
		sum += i;
	}
	System.out.println(sum);
}
```
ex) printf<br>

### 구현부
구현부는 중괄호 내에서 처리해야하는 니용 즉 비즈니스 로직 작성<br>
마지막에는 선언된 리턴 타입에 해당하는 값을 return 문장과 함께 반환해야 함<br>
- 값 반환 시에는 묵시적 형 변환 적용
- 리턴 타입이 void여서 반환할 값이 없을 경우 return 문장 생략 가능
- 메서드 수행 도중 return 문장을 만나거나 마지막 문장을 수행하는 경우 메서드는 종료
	- 조건문을 이용해서 return 할 경우 모든 조건에서 return 필요

### 메서드 호출
메서드를 호출할 때는 메서드의 선언부에 맞춰 호출해야 함<br>
- 메서드 이름 : 반드시 동일
- 파라미터 : 선언된 파라미터의 개수는 반드시 동일, 타입은 promotion 적용 가능<br>
메서드 접근 : 멤버 변수와 마찬가지로 static 또는 non static 상태를 구분해서 호출<br>
비고		static member	non static member(instance member)<br>
소속		클래스		객체<br>
접근 방법	같은 클래스	바로 호출		바로 호출<br>
	다른 클래스	클래스_이름.멤버_이름	객체_이름.멤버_이름<br>
- 가장 중요한 것은 호출하려는 멤버가 메모리에 있는가?
	- 메모리에 있으면 호출 가능
	- 메모리에 없으면 호출 불가 - 먼저 메모리에 로딩 후 사용해야 함<br>
<br>
class 멤버와 instance 멤버간의 참조와 호출<br>
가장 중요한 것은 메모리에 있는가?<br>
- 메모리에 있으면 호출 가능 
- 메모리에 없으면 호출 불가
static member -> 언제나 메모리에 있음<br>
- 클래스 로딩 시 자동 등록<br>
instance member -> 객체 생성 전에는 메모리에 없음<br>
- 객체 생성 시 모든 일반 멤버들은 메모리에 생성
- 객체 즉 레퍼런스를 통해서 접근

### 메서드 호출 스택
스택(stack)<br>
- First in Last out 구조
메서드 호출 스택<br>
- 각각의 메서드 호출 시 마다 메서드 동작을 위한 메모리 상자를 하나씩 할당
	- 상자 내부에 메서드를 위한 파라미터 변수 등 로컬 변수 구성
- A 메서드에서 새로운 메서드 B 호출 시 B 실행을 위한 메모리 상자를 쌓음
	- 언제나 맨 위에 있는 메모리 상자(B)만 활성화
	- 이때 A 메서드는 동작이 끝나지 않고 잠시 정지된 상태
	- B가 리턴하게 되면 B를 위한 상자가 제거되며 메모리 반납
	- 비로서 A가 최상위가 돼서 다시 동작 재게

### 기본형 변수와 참조형 변수
- 메서드 호출 시 파라미터로 입력된 값을 복사해서 전달
- Java는 call by value!! Value의 정체는?

### 메서드 오버로딩
overloading: 동일한 기능을 수행하는 메서드의 추가 작성<br>
- 일반적으로 메서드 이름은 기능별로 의미 있게 정함
- 동일한 기능을 여러 형태로 정의해야 한다면?

### 메서드 오버로딩의 장점
- 기억해야 할 메서드가 감소하고 중복 코드에 대한 효율적 관리 가능<br>

### 메서드 오버로딩 방법
메서드 이름은 동일<br>
파라미터의 개수 또는 순서, 타입이 달라야 할 것<br>
- 파라미터가 같은면 중복 선언 오류
리턴 타입은 의미 없음<br>
