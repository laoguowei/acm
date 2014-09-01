package com.chapter5;

public class MyPriorityQueue {

	/**
	 * @param args
	 */
	public int[] element = new int[10];
	private int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPriorityQueue mq = new MyPriorityQueue();
		int[] a = {34,67,12,89,34,6,1,8};
		for(int i = 0; i < a.length; i++) {
			mq.insert(a[i]);
		}
		for(int i = 0; i < a.length; i++) {
			System.out.println(mq.remove());
		}
		
	}
	
	public void insert(int data) {
		if(element.length == count) {
			int[] tmp = new int[count*2];
			System.arraycopy(element, 0, tmp, 0, count);
			element = tmp;
		}
		siftUp(data);
	}
	
	public int remove() {
		int re = siftDown();
		return re;
	}
	
	private void siftUp(int data) {
		int i = count + 1;
		for(;data < element[i / 2] && i > 1; i = i/2) {
			element[i] = element[i / 2];
		}
		element[i] = data;
		count++;
	}
	
	private int siftDown() {
		int re = element[1];
		int last = element[count];
		count--;
		int i = 1;
		for(; 2*i <= count;) {
			if(element[2*i] > element[2*i + 1]) {
				element[i] = element[2*i + 1];
				i = 2*i + 1;
			} else {
				element[i] = element[2*i];
				i = 2*i;
			}
		}
		element[i] = last;
		return re;
	}

}
