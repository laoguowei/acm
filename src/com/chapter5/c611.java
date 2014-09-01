package com.chapter5;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class c611 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ExecutorService es = Executors.newCachedThreadPool();
			server s = new server();
			for(int i = 0; i < 20; i++) {
				es.execute(new client(i, s));
			}
			es.shutdown();
	}
}

class server {
	private final ReentrantLock mainLock = new ReentrantLock();
	private int num = 10;
	public void sell(client c) {
		this.mainLock.lock();
		c.buy();
		if(num > 0) {			
			System.out.println(" " + num-- + " product");	
			
		} else {
			System.out.println(" sell out");
		}
		ConcurrentHashMap cm = new ConcurrentHashMap();
	
	}
}
class client implements Runnable{
	server s;
	int id;
	public client(int id, server s) {
		this.id = id;
		this.s = s;
	}
	public void buy() {
		System.out.print("client + " + id + " get");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		s.sell(this);
		//System.exit(0);
	}
}
	
	