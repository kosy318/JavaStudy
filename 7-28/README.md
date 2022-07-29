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
- File.separator : os에 적합한 separator를 넣어줌

```java
File target = new File("c:" + File.separator + "Temp" + File.separator + "diary.txt");
try (Scanner scanner = new Scanner(System.in); // 키보드 입력
    FileWriter writer = new FileWriter(target, true); // true는 append = true라는 의미
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
new DataInputStream(new BufferedInputStream(new FileInputStream()); // Stream Chain
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

```java
try (FileInputStream fi = new FileInputStream(src);
    FileOutputStream fo = new FileOutputStream(target);) { // 노드
  copy(fi, fo);
} catch (IOException e) {
  e.printStackTrace();
}

try (BufferedInputStream bi = new BufferedInputStream(new FileInputStream(src));
    BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(target));) { // 
  copy(bi, bo);
} catch (IOException e) {
  e.printStackTrace();
}
```
```java
public static void copy(InputStream input, OutputStream output) throws IOException {
long start = System.nanoTime();
byte[] cart = new byte[1024];
int read = -1;
while ((read = input.read(cart)) > 0) {
  output.write(cart, 0, read);
}
long end = System.nanoTime();
System.out.printf("소요 시간: %10dns%n", end - start);
```

#### BufferedReader() : readLine() -> 줄 단위로 데이터를 읽어들임
- BufferedReader(Reader in) : in을 이용해 크기가 8192인 버퍼를 갖는 BufferedReader을 생성
- BufferedReader(Reader in, int size) : in을 이용해 크기가 size인 버퍼를 갖는 BufferedReader을 생성
#### BufferedWriter()
- BufferedWriter(Writer out) : out을 이용해 크기가 8192인 버퍼를 갖는 BufferedWriter 생성
- BufferedWriter(Writer out, int size) : out을 이용해 크기가 size인 버퍼를 갖는 BufferedWriter 생성

```java
try (BufferedReader br = new BufferedReader(new FileReader(src));) {
    String line = null;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### 객체 직렬화(Serialization)
- 객체를 파일 등에 저장하거나 네트워크로 전송하기 위해 연속적인 데이터로 변환하는 것
- 반대의 경우는 역 직렬화(deserialization)
- 직렬화 되기 위한 조건
  - Serializable 인터페이스를 구현할 것
  - 클래스의 모든 멤버가 Serializable 인터페이스를 구현해야 함
  - 직렬화에서 제외하려는 멤버는 transient 선언

```java
implements Serializable // 필수

private trasient String str; // 직렬화 제외
```

- serialVersionUID
  - 클래스의 변경 여부를 파악하기 위한 유일 키
  - 직렬화 할 때의 UID와 역 직렬화 할 때의 UID가 다를 경우 예외 발생
  - 직렬화되는 객체에 UID가 설정되지 않았을 경우 컴파일러가 자동 생성
    - 멤버 변경으로 인한 컴파일 시마다 변경 -> InvalidClassException 초래
  - 직렬화되는 객체에 대해서 serialVersionUID 설정 권장

### ObjectInputStream, ObjectOutputStream
- ObjectInputStream(InputStream in) : in을 이용해 ObjectInputStream 객체를 생성
- readObject() : 직렬화된 데이터를 역직렬화해서 Object로 리턴한다.
<br>

- ObjectOutputStream(OutputStream out) : out을 이용해 ObjectOutputStream 객체를 생성
- writeObject(Object obj) : obj를 직렬화해서 출력한다.

### Scanner와 BufferedReader
- char 형태의 데이터를 읽기 위한 클래스들
- Scanner - 자동 형변환을 지원하는 등 사용이 간편하지만 속도가 느림
- BufferedReader - 직접 스트림을 구성해야 하는 등 번거롭지만 속도가 빠름


# 공공데이터와 XML
## 공공데이터 소개
### 공공데이터란?
- 공공기관이 만들어내는 모든 공적인 정보
- 각 공공기관이 보유한 데이터를 개방하여 누구나 원하는 기능에 활용 가능
- www.data.go.kr 등

### 데이터의 형태
- CSV : comma separated value
  - 용량이 작지만 구조적이지 못함
- xml : 태그를 통해 데이터 형식 정의
  - 구조적, 정확한 문법이 필요, 큰 용량
- json : JavaScript Object Notation 을 통해 데이터 형식 정의
  - 구조를 가지며 객체로 다른 언어와 호환

### XML
- Markup Language
  - 태그 등을 이용하여 문서나 데이터의 구조를 명기하는 언어
  - HTML, SGML, ...
- XML
  - Extensible Markup Language
- HTML과 달리
  - 필요에 따라 태그를 확장에서 사용 가능
  - 정확한 문법을 지켜야 동작: Well formed
### 기본 문법
- 문서의 시작은 <?xml version="1.0" encoding="UTF-8"?>로 한다.
- 반드시 root element가 존재해야 한다.
  - 나머지 태그들은 tree 형태로 구성
- 시작 태그와 종료 태그는 일치해야 한다.
- 시작 태그는 key-value 구조의 속성을 가질 수 있다.
  - 속성값은 " " 또는 ' '로 묶어서 표현한다.
- 태그는 대소문자를 구별한다.
### valid
- xml 태그는 자유롭게 생성하기 때문에 최초 작성자의 의도대로 작성되는지 확인할 필요
  - 문서의 구조와 적절한 요소, 속성들의 개수, 순서들이 잘 지켜졌는가?
  - DTD 또는 Schema를 이용해서 문서의 규칙 작성; 이를 잘 따른 문서를 valid하다 라고 함

# 문서의 Parsing
## XML 파싱
### 파싱
- 문서에서 필요한 정보를 얻기 위해 태그를 구별하고 내용을 추출하는 과정
  - 전문적인 parser 활용
- SAX parser
  - Simple API for XML parser
  - 문서를 읽으면서 태그의 시작, 종료 등 이벤트 기반으로 처리하는 방식
- DOM parser
  - Document Object Model
  - 문서를 다 읽고 난 후 문서 구조 전체를 자료구조에 저장하여 탐색하는 방식
- SAX는 빠르고 한번에 처리하기 때문에 다양한 탐색이 어렵다.
- DOM은 다양한 탐색이 가능하지만 느리고 무거우며 큰 문서를 처리하기 어렵다.

## SAX Parser
### 동작 방식
- 문서를 읽다가 발생하는 이벤트 기반으로 문서 처리
- DefaultHandler를 사용 -> extends DefaultHandler 필수!!!
#### 문자열 형태의 날짜를 Date로 변환해서 반환
```java
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
try {
  return format.parse(date);
} catch(ParseException e) {
  e.printStackTrace();
  return new Date();
}
```
### Handler 작성
```java
try {
  SAXParserFactory factory = SAXParserFactory.newInstance();
  SAXParser parser = factory.newSAXParser();
  parser.parse(xml, this);
} catch (IOException | SAXException | ParserConfigurationException e) {
  e.printStackTrace();
}
```
```java
@Override
public void startDocument() throws SAXException {
  System.out.println("문서 시작");
}

@Override
public void endDocument() throws SAXException {
  System.out.println("문서 종료");
}

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
  if(qName.equals("dailyBoxOffice")) {
    current = new BoxOffice();
  }
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException {
  this.content = new String(ch, start, length);
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
  if(qName.equals("dailyBoxOffice")) {
    list.add(current);
    current = null;
  } else if (qName.equals("rank")) {
    current.setRank(Integer.parseInt(content));
  } else if (qName.equals("movieNm")) {
    current.setMovieNm(content);
  } else if(qName.equals("openDt")) {
    current.setOpenDt(current.toDate(content));
  } else if(qName.equals("audiAcc")) {
    current.setAudiAcc(Integer.parseInt(content));
  }
}
```


## DOM Parser
### 동작 방식
- 문서를 완전히 메모리에 로딩 후 필요한 내용 찾기
- DOM Tree
  - 문서를 구성하는 모든 요소를 Node(태그, 속성, 값)로 구성
    - root Node, element Node, attribute Node, text Node
  - 태그들은 root 노드(주소록)을 시작으로 부모-자식의 관계 구성

```java
public List<BoxOffice> getBoxOffice() {
    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 문서 로딩 완료 --> 원하는 요소들 골라내기
        Document doc = builder.parse(xml);
        // 최 상위 element
        Element root = doc.getDocumentElement();
        parse(root);
    } catch (IOException | ParserConfigurationException | SAXException e) {
        e.printStackTrace();
    }
    return list;
}

private void parse(Element root) {
  NodeList boxOffices = root.getElementsByTagName("dailyBoxOffice");
  for(int i=0; i<boxOffices.getLength(); i++) {
    Node child = boxOffices.item(i);
    list.add(getBoxOffice(child));
  }
}

private static BoxOffice getBoxOffice(Node node) {
    BoxOffice boxOffice = new BoxOffice();
    // TODO: node 정보를 이용해서 BoxOffice를 구성하고 반환하시오.
    NodeList subNodes = node.getChildNodes();
    for(int j=0; j<subNodes.getLength(); j++) {
      Node sub = subNodes.item(j);
      if(sub.getNodeName().equals("rank")) {
        boxOffice.setRank(Integer.parseInt(sub.getTextContent()));
      } else if(sub.getNodeName().equals("movieNm")) {
        boxOffice.setMovieNm(sub.getTextContent());
      } else if(sub.getNodeName().equals("openDt")) {
        boxOffice.setOpenDt(boxOffice.toDate(sub.getTextContent()));
      } else if(sub.getNodeName().equals("audiAcc")) {
        boxOffice.setAudiAcc(Integer.parseInt(sub.getTextContent()));
      }
    }
    // END:
    return boxOffice;
}
```

## JSON
- JavaScript Object Notation(자바스크립트에서의 객체 표현법)
- 간결한 문법, 단순한 텍스트, 적은 용량으로 대부분의 언어, 대부분의 플랫폼에서 사용 가능
  - 기종간의 데이터 교환에 광범위하게 사용됨
- 객체를 key-value의 쌍으로 관리
- 다양한 라이브러리를 이용한 간편한 사용

```java
public List<BoxOffice> getBoxOffice() {
    ObjectMapper mapper = new ObjectMapper();

    // 날짜 변경과 관련된 룰 지정
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    // 기본적으로 map의 구조를 가짐
    Map<String, Map<String, Object>> result = mapper.readValue(json, Map.class);
    
    // 배열은 List
    List<Map<String, Object>> list = (List)result.get("boxOfficeResult").get("dailyBoxOfficeList");

    for(Map<String, Object> info : list) {
      BoxOffice boxOffice = mapper.convertValue(info, BoxOffice.class);
      System.out.println(boxOffice);
    }
    return list;
}
```

# Swing
- Java Application에서 사용되는 GUI(Graphic User Interface)를 제공하는 추상적으로 정의된 도구(컴포넌트) 모음
- Container
  - 다른 컴포넌트들을 배치하기 위한 컴포넌트
  - Container는 다른 Container를 포함할 수 있고 나중에 복합적인 Layout을 구성할 수 있게 한다.
  - JFrame: 독립적으로 사용될 수 있으며 타이틀과 사이즈를 조절할 수 있는 버튼을 가짐
  - JPanel: 반드시 다른 Container에 포함되어아 하며 복합적인 레이아웃 구성에 사용

### Layout과 LayoutManager
- Layout: Component들을 Container에 어떻게 배치할 것인가
- LayoutManager: Container별로 Component의 위치와 크기, 배치 방식을 결정하는 객체
<br>

- FlowLayout
  - JPanel의 기본 LayoutManager
  - 요소를 가로로 물 흐르듯이 배치
- BorderLayout
  - JFrame의 기본 LayoutManager
  - 특별한 영역 즉, North, South, West, East, Center에 각각의 컴포넌트를 배치한다.
    - component들을 배치할 때는 영역을 지정(BorderLayout.CENTER or "Center")
    - 사용하지 않는 공간의 크기가 0*0이 되고 Center가 기본이다.
    - 각각의 영역에는 하나의 Component를 담을 수 있고 중복해서 담을 경우는 마지막에 담은 컴포넌트만 보인다.
    - 크기를 조절할 때 North와 South는 좌우로, East와 West는 상하로만 늘어난다. Center는 양방향
<br>

- Layout 설정
  - 생성자 또는 setLayout 메소드로 layout 변경 가능
  ```java
  JPanel panel = new JPanel(); // FlowLayout
  panel.setLayout(new BorderLayout()); // BorderLayout
  
  JPanel panel2 = new JPanel(new GridLayout()); // GridLayout
  ```
- 복합적인 Layout 구성
  - container 안에 또다른 Container를 배치하는 형태로 복합적인 Layout 구성

## Event Handling
### 이벤트 처리 모델(Delegation Model)
- 위임형 모델
- 실제로 이벤트가 일어나는 것은 component 이지만 거기서 처리되는 것이 아니라 이벤트 리스너를 등록시킨 후 위임 받은 handler 클래스 내에서 이벤트 처리
### 이벤트 처리 클래스
- XX Listener
  - 이벤트 처리에 대한 메서드들을 정의한 인터페이스로 handler는 이 인터페이스를 구현
  - 하나의 component에 여러 개의 event handle를 붙일 수 있다.'
    - implements ActionListenger, WindowListener
- XXEventAdapter
  - Listener를 implements할 경우 사용하지도 않는 이벤트 핸들러까지 다 구현해야 하는 단점
  - xxxEventAdapter implements XXListener
    - 해당 메서드들을 모조뢰 구현해 놓은 class, 구현 내용은 비어있는 {}
    - 상속받은 후 필요한 것만 override하면 된다.

<br>
<img src="https://user-images.githubusercontent.com/77595685/181559157-7bb52ebc-10ee-4dc0-844b-83289274c324.png" width=400px>
<br>

```java
// extends JFrame !!!!
private static final long serialVersionUID = 1L;
private JLabel lNum1, lNum2, lCorrectCnt, lWrongCnt;
private JTextField tfAns;
private int answer;

public static void main(String[] args) {
    LayoutTest lt = new LayoutTest();
    lt.launchUi();
}

private void launchUi() {
    this.add(new JLabel("구구단을 외자!"), BorderLayout.NORTH);

    makeResultPanel();
    makeProblemPanel();

    // Frame 기본 설정
    this.setTitle("layout test");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
}

private void makeProblem() {
    Random rand = new Random();
    int num1 = rand.nextInt(9) + 1;
    int num2 = rand.nextInt(9) + 1;
    this.answer = num1 * num2;
    lNum1.setText(num1 + "");
    lNum2.setText(num2 + "");
    tfAns.setText("");        
}

private void makeResultPanel() {
  JPanel panel = new JPanel();

  panel.add(new JLabel("정답 개수: "));
  lCorrectCnt = new JLabel("0");
  panel.add(lCorrectCnt);
  panel.add(new JLabel("오답 개수: "));
  lWrongCnt = new JLabel("0");
  panel.add(lWrongCnt);

  this.add(panel, BorderLayout.SOUTH);
}



private void makeProblemPanel() {
  JPanel panel = new JPanel();

  lNum1 = new JLabel();
  lNum2 = new JLabel();

  panel.add(lNum1);
  panel.add(new JLabel("*"));
  panel.add(lNum2);
  panel.add(new JLabel("="));

  tfAns = new JTextField(10);
  panel.add(tfAns);

  makeProblem();
  tfAns.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) { // 눌리고 올라오는 순간
      if(e.getKeyCode() == 10) {
        int val = Integer.parseInt(tfAns.getText());
        if(val == answer) {
          int pre = Integer.parseInt(lCorrectCnt.getText());
          lCorrectCnt.setText(pre + 1 + "");
        } else {
          int pre = Integer.parseInt(lWrongCnt.getText());
          lWrongCnt.setText(pre + 1 + "");
        }
        makeProblem();
      }
    }
});

    this.add(panel, BorderLayout.CENTER);
}
```
#### JTable
```java
JTable table = null;

// table의 데이터를 관리하는 객체
DefaultTableModel model = null;
```
```java
// 테이블 구성
table = new JTable();
String[] header = {"랭킹", "제목", "개봉일", "누적관객"};
model = (DefaultTableModel) table.getModel();
model.setColumnIdentifiers(header);
```
#### 버튼이 눌렸을 때, 테이블 업뎃
```java
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 기존 자료 삭제
        model.setRowCount(0);
        
        // 새로운 자료 조회
        BoxOfficeDomParser parser = new BoxOfficeDomParser();
        List<BoxOffice> list = parser.getBoxOffice();
        for (BoxOffice info : list) { // table setting
            model.addRow(new Object[] {info.getRank(), info.getMovieNm(), info.getOpenDt(), info.getAudiAcc()});
        }
        // model의 데이터가 변경되었음을 알림
        model.fireTableDataChanged();
    }
});
```
#### table이 클릭되었을 때
```java
table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow(); // 선택된 row 가져오기
        String name = model.getValueAt(row, 1).toString();
        JOptionPane.showMessageDialog(BoxOfficeUi.this, "선택된 영화 정보: " + name);
      }
});
```

<hr>

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
