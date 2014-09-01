package com.chapter5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Test1 {

	/**
	 * @param args
	 */
	public static int k = 0;
	public static Test1 t1 = new Test1("t1");
	public static Test1 t2 = new Test1("t2");
	public static int i = print("i");
	public static int n = 99;
	public int j = print("j");
	{
		print("¹¹Ôì¿é");
	}
	static {
		print("¾²Ì¬¿é");
	}
	public Test1(String str) {
		System.out.println((++k) + ":" + str + "  i" + i + "   n" + n);
	}
	public static int print(String str) {
		System.out.println((++k) + ":" + str + "  i" + i + "   n" + n);
		++n;
		return ++i;
	}
	static Semaphore sp = new Semaphore(1);
	static int num = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i = 0; i < 20; i++) {
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Test1.sp.acquire();					
						if(num > 0) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println(Thread.currentThread().getName() + " get " + num--);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						sp.release();
					}
				}
			});
		}
		es.shutdown();
	}
	
	public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for(int i = 0; i < nThreads; i++) {
			new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ie) { 
						
					}
				}
			}.start();
		}
		long startTime = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

}
