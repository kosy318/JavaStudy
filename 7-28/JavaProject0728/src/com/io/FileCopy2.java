package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// try with resource : 예외 발생 여부와 관계없이 stream 사용 후 자동으로 close 시켜주는 기능
/* try (스트림생성묹장; 스트림생성문장2; ...) {
 * 		스트림 사용...
 * } catch() {} */

public class FileCopy2 {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("src\\com\\io\\FileCopy.java");
			FileOutputStream fos = new FileOutputStream("src\\com\\io\\Other.java");){
			int i = 0;
			while((i = fis.read()) != -1){
				fos.write(i); // ascii code에 해당하는 글자로 바꿔서 적어줌
			}
			
			System.out.println("file copied");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
