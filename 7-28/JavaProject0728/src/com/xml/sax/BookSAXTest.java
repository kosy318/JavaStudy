package com.xml.sax;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class BookSAXTest {

	public static void main(String[] args) {
		//SAXParser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			
			//handler: xml문서를 파싱할 정보를 가지고 있는 객체
			BookSaxHandler handler = new BookSaxHandler();
			parser.parse("src/com/xml/sax/book.xml", handler);
			
			List<Book> list = handler.getList();
			for (Book book : list) {
				System.out.println(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
