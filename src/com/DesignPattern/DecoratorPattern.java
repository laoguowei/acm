package com.DesignPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoratorPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			InputStream is = new LowerCaseInputStream(new FileInputStream("d://test.txt"));
//			int c;
//			while((c = is.read()) >= 0) {
//				System.out.print((char)c);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	

}

class LowerCaseInputStream extends FilterInputStream {

	protected LowerCaseInputStream(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}
	
}

class father {
	static void staticMethod() {
		System.out.println("f");
	}
}
class son extends father {
	static void staticMethod() {
		System.out.println("s");
	}
}