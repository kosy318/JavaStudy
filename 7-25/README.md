- class 이름 얻기
```java
this.getClass().getSimpleName();
```

# abstract class(추상클래스)
### 추상 클래스 정의
- 자손 클래스에서 반드시 재정의해서 사용되기 때문에 조상의 구현이 무의미한 메소드
  - 메소드의 선언부만 남기고 구현부는 ;으로 대체
  - 구현부가 없다는 의미로 abstract 키워드를 메소드 선언부에 추가
  - 객체를 생성할 수 없는 클래스라는 의미로 클래스 선언부에 abstract를 추가한다.

### 추상 클래스의 특징
- abstract 클래스는 상속 전용의 클래스
  - 클래스에 구현부가 없는 메소드가 있으므로 객체를 생성할 수 없음
  - 하지만 상위 클래스 타입으로써 자식을 참조할 수는 있다.
```java
Vehicle v = new Vehicle(); // abstract 클래스는 객체를 생성할 수 없다.
Vehicle v = new DieselSUV(); // 자식을 참조하는 것은 문제 없음
```
- 조상 클래스에서 상속받은 abstract 메소드를 재정의 하지 않은 경우
  - 클래스 내부에 abstract 메소드가 있는 상황이므로 자식 클래스는 abstract 클래스로 선언되어야함

### 추상 클래스를 사용하는 이유
- abstract 클래스는 구현의 강제를 통해 프로그램의 안정성 향상
- interface에 있는 메소드 중 구현할 수 있는 메소드를 구현해 개발의 편의 지원

#### 추상 메소드: 함수의 body{}부분이 없는 미완성의 함수
```java
public abstract void go(String m);
```
#### 추상 클래스: 추상 메소드를 가지는 클래스
```java
public abstract class MyAbstract{
	public abstract void go(String m);
}
```
- abstract <-> concrete(구상, 구체적인)
- 미완성의 클래스 이므로 생성불가
```java
public abstract class MyAbstract{}
MyAbstract m = new MyAbstract(); (X)
```
- 다른 클래스에서 추상 클래스를 상속해서 미완성의 메소드를 구현(완성)해 줘야함
```java
public class Complete extends MyAbstract{
  public void go(String m){}
}
```

# Interface
### 인터페이스란?
- GUI - Graphic User Interface
  - 프로그램과 사용자 사이의 접점

### 인터페이스 작성
- 최고 수준의 추상화 단계: 일반 메소드는 모두 abstract 형태
- 형태
  - 클래스와 유사하게 interface 선언
  - 멤버구성
    - 모든 멤버변수는 public static final이며 생략 가능
    - 모든 메서드는 public abstract이며 생략 가능

### 인터페이스 상속
- 클래스와 마찬가지로 인터페이스도 extends를 이용해 상속이 가능
- 클래스와 다른 점은 인터페이스는 다중 상속이 가능, 헷갈릴 메소드 구현 자체가 없다.

### 인터페이스 구현과 객체 참조
- 클래스에서 implements 키워드를 사용해서 interface 구현
- implements한 클래스 (강제성!!)
  - 모든 abstract 메소드를 override해서 구현하거나
  - 구현하지 않을 경우 abstract 클래스로 표시해야 함
- 여러개의 interface implements 가능
- 인터페이스도 하나의 타입 -> 다형성은 가능하다!

## Interface의 필요성
### 인터페이스의 필요성
- 구현의 강제로 표준화 처리
  - abstract 메소드 사용
- 인터페이스를 통한 간접적인 클래스 사용으로 손쉬운 모듈 교체 지원
- 서로 상속의 관계가 없는 클래스들에게 인터페이스를 통한 관계 부여로 다형성 확장
- 모듈 간 독립적 프로그래밍 가능 -> 개발 기간 단축

### default method
- 인터페이스에 선언 된 구현부가 있는 일반 메소드
  - 메소드 선언부에 default modifier 추가 후 메소드 구현부 작성
    - 접근제한자는 public으로 한정됨(생략 가능)
  ```java
  interface DefaultMethod(){
    void abstractMethod();
    
    default void defaultMethod(){
      System.out.println("이것은 기본 메소드 입니다.");
    }
  }
  ```
- 필요성
  - 기존에 interface 기반으로 동작하는 라이브러리의 interface에 추가해야 하는 기능이 발생
  - 기존 방식으로라면 모든 구현체들이 추가되는 메소드를 override해야함
  - default 메소드는 abstract가 아니므로 반드시 구현해야 할 필요는 없어짐

### defaultmethod의 충돌
- JDK1.7 이하의 java에서는 interface method에 구현부가 없으므로 충돌이 없었음
- JDK1.8 부터 default method가 생기면서 동일한 이름을 갖는 구현부가 있는 메서드가 충돌
- method 우선순위
  - super class의 method가 우선: super class가 구체적인 method를 갖는 경우 default method는 무시됨
  - interface간의 충돌: 
하나의 interface에서 default method를 제공하고 다른 interface에서도 같은 이름의 method(default 유무와 무관)가 있을 때 sub class는 반드시 override해서 충돌을 해결해야한다.

### static method
- interface에 선언된 static method
  - 일반 static method와 마찬가지로 별도의 객체가 필요 없음
  - 구현체 클래스 없이 바로 인터페이스 이름으로 method에 접근해서 사용 가능
```java
interface StaticMethodInterface{
  static void staticMethod(){
    System.out.println("Static method");
  }
}

public class StaticMethodTest {
  public static void main(String[] args){
    StaticMethodInterface.staticMethod();
  }
}
```
# Generics
- 다양한 타입의 객체를 다루는 메서드, 컬렉션 클래스에서 "컴파일 시에 타입 체크"
  - 미리 사용할 타입을 명시해서 형 변환을 하지 않아도 되게 함
    - 객체의 타입에 대한 안전성 향상 및 형 변환의 번거로움 감소

### 표현
- 클래스 또는 인터페이스 선언 시 <>에 타입 파라미터 표시
```java
public class Class_Name<T> {}
public interface Interface_Name<T> {}
```
  - Class_Name: Raw Type
  - Class_Name<T>: Generic Type
- 타입 파라미터
  - 특별한 의미의 알파벳보다는 단순히 임의의 참조형 타입을 말함
  - T: reference Type, E: Element, K: Key, V: Value
- 객체 생성
  - 변수 쪽과 생성 쪽의 타입은 반드시 같아야함
  ```java
  ClassName<Number> generic = new ClassName<Number>();
  ClassName<Number> generic2 = new ClassName<>(); // 뒤쪽 생략 가능
  ```
  - Object를 사용하면 뭐든지 넣을 수 있지만, 다시 받아올 때 instanceof로 확인해서 받아와야하는 번거로움이 있음
  - Generic을 사용하면 "어떤 타입"으로 파라미터를 설정해야하지만, runtime에 발생 할 수 있는 오류가 줄어듦
    - 만능 박스로 사용하고싶으면 타입을 "Object"로 지정해주면 된다.
  ```java
  class GenericBox<T> {
    private T some;
  
    public T getSome() {
      return some;
    }
  
    public void setSome(T some) {
      this.some = some;
    }
  }
  ```<br>
  
  ### type parameter의 제한
  - 필요에 따라 구체적인 타입 제한 필요
    - 계산기 프로그램 구현 시 Number 이하의 타입(Byte, Short, Integer...)로만 제한
      - type parameter 선언 뒤 extends와 함께 상위 타입 명시
      ```java
      class NumberBox<T extends Number> // T는 Number를 상속받은 것만 가능하다
      ```
    - 인터페이스로 제한할 경우도 extends 사용
    - 클래스와 함께 인터페이스 제약 조건을 이용할 경우 &로 연결

### Generic Type 객체를 할당 받을 때 와일드 카드 이용
- generic type에서 구체적인 타입 대신 사용<br>
  |표현|설명|
  |:----|:----|
  |Generic type<?>|타입이 제한이 없음(Object)|
  |Generic type<? extends T>|T 또는 T를 상속받은 타입들만 사용 가능|
  |Generic type<? super T>|T 또는 T의 조상 타입만 사용 가능|

### Generic Method
- 파라미터 리턴 타입으로 type parameter를 갖는 method
  - method 리턴 타입 앞에 타입 파라미터 변수 선언
```java
[제한자] <타입_파라미터, [...]> 리턴_타입 method_이름(파라미터){}
```
