package com.chapter5;

import java.util.Scanner;
public class Run{
	public static boolean[][] edges = null;
	public static boolean[] nodes = null;
	public static boolean[] path = null;
	public static void main(String args[]){
		Run r= new Run();
		try{
			String retString = r.test();
			Thread.sleep(500);
			System.out.println("return String" + retString);
		} catch (InterruptedException e) {
			// TODO: handle exception
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String test() throws Throwable {
		String retString = "start";
		StringBuilder sb = new StringBuilder();
		retString = retString + "fdsfsdf";
		try {
			System.out.println("start String" + retString);
			retString = "try inner";
			throw new Exception("Exceprion inner");
		}
		catch (Exception e){
			retString = "catch inner";
			return retString;
		} finally {
			retString = "final string";
			System.out.println("final string" + retString);
			return retString;
		}
	}


}