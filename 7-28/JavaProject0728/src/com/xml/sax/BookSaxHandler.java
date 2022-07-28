package com.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//sax handler
public class BookSaxHandler extends DefaultHandler {
	List<Book> list;
	Book book;
	String txt;
	
	public BookSaxHandler() {
		list = new ArrayList<>();
	}
	
	//엘리먼트가 시작 될때 자동 실행(시작 태그를 만날 때)
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("book")) {
			book = new Book();
		}
	}

	//엘리먼트가 끝날때 자동 실행(끝 태그를 만날 때)
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(book != null) {
			if(qName.equals("isbn")) {
				book.setIsbn(txt);
			} else if(qName.equals("title")) {
				book.setTitle(txt);
			} else if(qName.equals("author")) {
				book.setAuthor(txt);
			} else if(qName.equals("publisher")) {
				book.setPublisher(txt);
			} else if(qName.equals("price")) {
				book.setPrice(txt);
			} else if(qName.equals("book")) {//책한권 정보가 끝남
				list.add(book);
				book = null;
			}				
		}
	}

	//시작태그와 끝태그 사이의 글자를 만나면 자동 실행
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		txt = new String(ch, start, length).trim();
	}
	
	public List<Book> getList(){
		return list;
	}
	
}
