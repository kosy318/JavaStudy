### JCF(Java Collection Framework)
- 여러개의 데이터를 저장하고 관리할 수 있는 자료구조
- 데이터 저장/관리 방식에 따라 List/Set/Map구조로 나뉨

### Collection 관련 클래스
|List|Set|Map(Collection 아님)|
|:--:|:--:|:--:|
|순서o<br>중복o|순서x<br>중복x|(Key, Value)|
|Vector<br>ArrayList|HashSet|HashMap<br>HashTable|

### Vector
- 초기화
  ```java
  // default 초기 용량이 10
  // 용량이 모자라면 크기가 2배씩 늘어남
  Vector v = new Vector(initial_capacity);
  Vector<type> v = new Vector<>();
  
  // 용량이 모자라면 크기가 capacity_increment만큼 늘어남
  Vector v = new Vector(initial_capacity, capacity_increment);
  ```
- 추가
  ```java
  vector.add(ele); // generic을 사용하지 않으면 타입이 달라도 됨
  
  // index 위치에 추가
  // 데이터들이 뒤로 밀림
  vector.add(index, ele);
  ```
- 제거
  ```java
  // 삭제하는 값 반환
  // 다음 칸에 있는것들이 당겨옴
  vector.remove(index);
  vector.remove(object);
  
  // 전체 삭제
  vector.clear();
  ```
- 사이즈
  ```java
  vector.size();
  ```
- 용량
  ```java
  vector.capacity(); // 내부 배열 크기
  ```
- index 위치 element 가져오기
  ```java
  vector.get(index);
  ```
### ArrayList
> 중복o, 순서o

- 초기화
  ```java
  ArrayaList<type> list = new ArrayList<>();
  ```
- 추가
  ```java
  arraylist.add(ele);
  ```

### HashSet
> set: 중복 x, 순서 x

- 초기화
  ```java
  HashSet<type> set = new HashSet<>();
  ```
- 추가
  ```java
  set.add(ele);
  ```
- 제거
  ```java
  set.remove(ele);
  ```

### HashMap
> map: (key, value)의 쌍으로 이루어진 자료구조. key는 중복되면 안됨.

> |HashTable|HashMap|
> |:--:|:--:|
> |old|new|
> |synchronized<br>동기화o<br>한번에 하나의 프로그램만<br>작업 가능|not synchronized<br>동기화x<br>여러 프로그램이 동시에<br> 접근 가능<br>속도가 좀 더 빠름|

> 동시에 접근하면 안되면 그 데이터만 동기화 시키면 됨

- 초기화
  ```java
  HashMap<key_type, value_type> map = new HashMap<>();
  ```
- 추가
  ```java
  map.put("key", "value");
  ```
- 출력
  ```java
  System.out.println(map);
  ```
- key들 받아오기
  ```java
  // set 형식
  Set<key_type> set = map.keySet();
  ```
- value값에 접근
  ```java
  map.get(key);
  ```

## Exception Handling
### Exception
- 프로그램 실행 중 발생하는 문제<br>
ex) 데이터베이스 연결 시, 파일 입/출력 시, 배열의 잘못된 인덱스 접근<br>
<br>

### Error vs Exception
#### Error
- 복구 불가능한 문제 상황
- StackOverFlowError, NoSuchMethodError

#### Exception
- 복구 가능한 문제 상황
- RuntimeException :일단 실행은 됨<br>
  ex) ArrayIndexOutOfBoundException, ArithmeticException, NullPointerException<br>
  
- Non-RuntimeException : 예외처리를 하지 않으면 컴파일 불가<br>
  ex) IOException, InterruptedException, FileNotFoundException

### Exception Handling
1. 예외가 발생한 곳에서 직접 처리<br>
  try ~ catch ~ finally
2. 호출자로 보내서 예외처리 위임<br>
  throws
  
### Exception Handling -1
```java
try{
  예외 발생가능한 코드
}
catch(예외클래스명 변수명) {
  예외 처리 코드
} catch(예외클래스명 변수명) {
  예외 처리 코드
}
finally {
  예외 발생 여부와 관계없이 항상 실행될 코드
}
```

### Exception Handling -2
- 메소드에 throw가 붙어있으면 반드시 예외 처리를 해줘야한다.
1. try ~ catch
2. 상위 메소드에 throw로 예외처리
