package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src\\com\\io\\FileCopy.java"); // file에서 읽어오는 Input Stream
			FileOutputStream fos = new FileOutputStream("src\\com\\io\\Other.java"); // file에 쓰는 Output Stream

			int i = 0;
			while((i = fis.read()) != -1){
				System.out.printf("%c", i);
				fos.write(i); // ascii code에 해당하는 글자로 바꿔서 적어줌
			}

			fis.close();
			fos.close();

			System.out.println("file copied");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
