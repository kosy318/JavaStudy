# IO
## 노드스트림
### I/O - Stream
- I/O? 데이터의 입력(input)과 출력(output)
- 데이터는 한쪽에서 주고 한쪽에서 받는 구조로 되어있음
  - 입력과 출력의 끝단: Node
  - 두 노드를 연결하고 데이터를 전송할 수 있는 개념: Stream
    - 입력 스트림: InputStrema, Reader
    - 출력 스트림: OutputStream, Writer
  - 단방향으로만 통신이 가능하며 하나의 스트림으로 입출력을 같이 처리할 수 없음

### Node Stream의 종류와 nameing
node에 연결되는 스트림<br>
<img src="https://user-images.githubusercontent.com/77595685/181436260-18870381-0a0b-4ae8-abb5-ae2246cf9abf.png" width=700px>
<br>

### try with resource
예외 발생 여부와 관계없이 stream 사용 후 자동으로 close 시켜주는 기능
```java
try() {
} catch() {}
```

### InputStream의 주요 메소드
> Byte 단위로 읽을 때 사용
#### read()
- read() : byte 하나를 읽어서 int로 반환, 더 이상 읽을 값이 없으면 -1을 리턴
- read(byte b[]) : 데이터를 읽어서 b를 채우고 읽은 바이트 개수를 리턴, 더 이상 읽을 값이 없으면 0을 리턴
- read(byte b[], int offset, int len) : 최대 len만큼 데이터를 읽어서 b의 offset부터 b에 저장하고 읽은 바이트 개수를 리턴, len+offset은 b의 크기 이하
#### close()
- close() : 스트림을 종료해서 자원을 반납한다.

```java
try (InputStream input = new ByteArrayInputStream(data.getBytes())) {
    int read = -1;
    while ((read = input.read()) != -1) {
        System.out.printf("%c", read); // 일케 출력해야함
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Reader의 주요 메소드
> char 단위로 읽을 때 사용
#### read()
- read() : char 하나를 읽어서 int로 반환, 더 이상 읽을 값이 없으면 -1을 리턴
- read(char buf[]) : 데이터를 읽어서 buf를 채우고 읽은 문자 개수를 리턴, 더 이상 읽을 값이 없으면 0을 리턴
- read(char buf[], int offset, int len) : 최대 len만큼 데이터를 읽어서 buf의 offset부터 buf에 저장하고 읽은 문자 개수를 리턴, len+offset은 buf의 크기 이하
- read(java.nio.CahrBuffer target) : 데이터를 읽어서 target에 저장, target은 buf 대체
#### close()
- close() : 스트림을 종료해서 자원을 반납한다.

```java
char[] buffer = new char[10];
try (Reader input = new CharArrayReader(korean.toCharArray())) {
    int read = -1;
    while ((read = input.read(buffer)) > 0) {
        System.out.printf("%d, %s\n", read, new String(buffer, 0, read));
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### OutputStream의 주요 메소드
> Byte 단위로 쓸 때 사용
#### write()
- write(int b) : b의 내용을 byte로 출력
- write(byte b[]) : b를 문자열로 변환해서 출력
- write(byte b[], int offset, int len) : b의 offsset부터 offset+len-1만큼을 문자열로 변환해서 출력
#### close()
- close() : 스트림을 종료해서 자원을 반납한다. 내부적으로 flush()를 호출
#### flush()
- flush() : 버퍼가 있는 스트림에서 버퍼의 내용을 출력하고 버퍼를 비운다.


### Writer의 주요 메소드
> Char 단위로 쓸 때 사용
#### write()
- write(int b) : b의 내용을 char로 출력
- write(char buf[]) : buf를 문자열로 변환해서 출력
- write(char buf[], int offset, int len) : buf의 offsset부터 offset+len-1만큼을 문자열로 변환해서 출력
- write(String str) : str을 출력
- write(String str, int offset, int len) : str의 offset부터 offset+len-1만큼 출력
#### append()
- append(CharSequence c) : c를 출력하고 Writer를 리턴
- append(CharSequence c, int start, int end) : c의 start부터 end까지 출력하고 Writer를 리턴
#### close()
- close() : 스트림을 종료해서 자원을 반납한다. 내부적으로 flush()를 호출
#### flush()
- flush() : 버퍼가 있는 스트림에서 버퍼의 내용을 출력하고 버퍼를 비운다.

### File
> 가장 기본적인 입출력 장치 중 하나로 파일과 디렉터리를 다루는 클래스
현재 경로를 아는 방법
```java
File current = new File(".");
System.out.println(current.getCanonicalPath());
```
```java
//  프로젝트 내부에서 파일을 찾을 때
readMe = new File("bin\\com\\ssafy\\live5\\io\\node\\readme.txt");
//  특정 클래스 기준으로 파일을 찾을 때; 중간에 한글, 공백 x
readMe = new File(UseFileStream.class.getResource("readme.txt").getFile());
```

### FileInputStream, FileOutputStream
#### FileInputStream()
- FileInputStream(String name) : name 경로의 파일을 읽는 FileInputStream을 생성
#### FileOutputStream()
- FileOutputStream(String name) : name 경로의 파일에 출력하는 FileOutputStream을 생성한다
- FileOutputStream(String name, boolean append) : name 경로의 파일에 출력하는 FileOutputStream을 생성한다. 기존에 파일이 있다면 뒤에 이어 쓴다.

```java
long start = System.currentTimeMillis(); // 지금 시간
File src = new File("filepath1");
File target = new File("filepath2");

// file 옮기기
try(FileInputStream fin = new FileInputStream(src);
  FileOutputStream fout = new FileOutputStream(target);){
  byte[] buffer = new byte[bufferSize];
  int read = 0;
  while((read = fin.read(buffer)) > 0) {
    fout.write(buffer, 0, read);
  }
}catch(IOException e) {
  e.printStackTrace();
}

return System.currentTimeMillis() - start; // 시간 재는 법!!
```

### FileReader, FileWriter
```java
File target = new File("c:" + File.separator + "Temp" + File.separator + "diary.txt");
try (Scanner scanner = new Scanner(System.in); // 키보드 입력
    FileWriter writer = new FileWriter(target, true);
    FileReader reader = new FileReader(target);) {

    System.out.println("일기를 작성합니다. 그만두려면 x를 입력하세요.");
    writer.write("\n오늘 날짜: - " + new Date() + "\n");
    
    String str = null;
    while(true) {
      str = scanner.nextLine();
      if(str.equals("X")) {
        break;
      } else {
        writer.write(str + "\n");
      }
    }
    System.out.println("일기 저장 완료!!");

    char[] buffer = new char[10];
    int read = -1;
    while((read = reader.read(buffer)) > 0) {
      System.out.print(String.valueOf(buffer, 0, read));
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

# 보조스트림
## 보조 스트림의 개념과 종류
### 보조 스트림
Filter Stream, Processing Stream
- 다른 스트림에 부가적인 기능을 제공하는 스트림
  - 문자 set 변환, Buffering, 기본 데이터 형의 전송, 객체 입출력
- 스트림 체이닝(Stream Chaining)
  - 필요에 따라 여러 보조 스트림을 연결해서 사용 가능

### 보조 스트림의 종류
|기능|byte 기반|char 기반|
|:--:|:--:|:--:|
|byte 스트림을 char 스트림으로 변환|InputStreamReader<br>OutputStreamWriter||
|버퍼링을 통한 속도 향상|BufferedInputStream<br>BufferedOutputStream|BufferedREader<br>BufferedWriter|
|객체 전송|ObjectInputStream<br>ObjectOutputStream||

- 생성 - 이전 스트림을 생성자의 파라미터에 연결
```java
new BufferedInputStream(System.in);
new DataInputStream(new BufferedInputStream(new FileInputStream());
```
- 종료 - 보조 스트림의 close()를 호출하면 노드 스트림의 close()까지 호출 됨

### 사용할 스트림의 결정 과정
노드가 무엇인가 -> 타입은 문자열인가? 바이트인가? -> 방향이 무엇인가?(여기까지 노드 스트림) -> 추가 기능이 필요한가?(보조스트림)

# 보조스트림 활용
### InputStreamReader & OutputStreamWriter
- byte 기반 스트림을 char 기반으로 변경해주는 스트림
  - 문자열을 관리하기 위해서는 byte 단위보다 char 단위가 유리
  - 키보드에서 입력(byte stream) 받은 데이터를 처리할 경우 등
- 변환 시 encoding 지정 가능
#### InputStreamReader()
- InputStreamReader(InputStream in) : 기본 char set을 이용해서 InputStreamReader를 생성
- InputStreamReader(InputStream in, String charsetName) : charsetName을 이용해 InputStreamReader를 생성
- InputStreamReader(InputStream in, Charset cs) : cs를 이용해 InputStreamReader를 생성
#### OutputStreamWriter()
- OutputStreamWriter(OutputStream out) : 기본 char set을 이용해서 OutputStreamWriter를 생성
- OutputStreamWriter(OutputStream out, String charsetName) : charsetName을 이용해 OutputStreamWriter를 생성
- OutputStreamWriter(OutputStream out, Charset cs) : cs를 이용해 OutputStreamWriter를 생성

### Buffered 계열
- 버퍼의 역할
- 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 스트림
#### BufferedInputStream()
- BufferedInputStream(InputStream in) : in을 이용해 크기가 8192인 버퍼를 갖는 BufferedInputStream을 생성
- BufferedInputStream(InputStream in, int size) : in을 이용해 크기가 size인 버퍼를 갖는 BufferedInputStream을 생성
#### BufferedOutputStream()
- BufferedOutputStream(OutputStream out) : out을 이용해 크기가 8192인 버퍼를 갖는 BufferedOutputStream을 생성
- BufferedOutputStream(OutputStream out, int size) : out을 이용해 크기가 size인 버퍼를 갖는 BufferedOutputStream을 생성



# 공공데이터와 XML

# 문서의 Parsing

# Swing

## Stream
일련의 데이터를 이동시키는 입출력 파이프 혹은 그 데이터

### Stream 종류
|구분|Stream 종류|
|:--:|:--:|
|입력용/출력용|InputStream<br>OutputStream|
|입출력 단위<br>(char/byte)|Chracter Stream<br>Byte Stream|
|데이터입출력방법<br>(직/간접)|Node(Sink) Stream<br>Process Stream|

InputStream, Reader의 기능은 똑같지만 읽어낼때 단위가 다름

### Node(Sink) Stream
소스에 바로 연결된 Stream
|근원지/<br>목적지|Byte Stream|Character stream|
|:--:|:--:|:--:|
|memory|ByteArrayInputStream<br>ByteArrayOutputStream|CharArrayReader<br>CharArrayWriter|
|file|FileInputStream<br>FileOutputStream|FileReader<br>FileWriter|

### Process Stream
가공(filtering) 후에 읽어오는 것이 목적<br>
소스에 직접 연결 x
|처리|Byte Stream|Character<br>Stream|
|:--:|:--:|:--:|
|버퍼링|BufferedInputStream<br>BufferedOutputStream|BufferedReader<br>BufferedWriter|
|자료변환<br>(기본자료형인식)|DataInputStream<br>DataOutputStream||
|객체직렬화<br>(객체입출력)|ObjectInputStream<br>ObjectOutputStream||
