package com.chapter5;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Interrupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				PriorityQueue q = new PriorityQueue();
				ExecutorService es = Executors.newCachedThreadPool();
				
				try {
					LinkedBlockingQueue lbq = new LinkedBlockingQueue();		
					while(!Thread.currentThread().isInterrupted()) {
						//Thread.sleep(1000);
						System.out.println(i++);
						//lbq.put(i);
						
					}
					System.out.println(Thread.currentThread().isInterrupted());
				} catch (Exception e) {
					System.out.println("Inter");
				}
			}
		});

		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}

}
