package com.chapter5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomWords {

	/**
	 * @param args
	 */
	static ExecutorService ex = Executors.newCachedThreadPool();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "abcd";
		Thread[] t = new Thread[ss.length()];
		for(int i = 0; i < t.length; i++) {
			RandomWords.ex.execute(new task(ss.charAt(i)));

	
		}
	}

}

class task implements Runnable{
	char c;
	public task(char c){
		this.c = c;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
			System.out.print(c);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.exit(0);

	}
	
}
