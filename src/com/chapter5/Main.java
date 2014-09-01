package com.chapter5;

import java.lang.ref.SoftReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class S {
	private int a = 1;
	public int getA() {
		return a;
	}
}

class c extends S {
	
}

public class Main {

	/**
	 * @param args
	 */
	static int sum = 0;
	public static Main SAVE_HOOK = null;
	public void isAlive() {
		System.out.println("i'm alive");
	}
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		Main.SAVE_HOOK = this;
	}
	public static void main(String[] args) {
			c c1 = new c();
			System.out.print(c1.getA());
		
	}
	public static void solution(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		StringBuilder sb = new StringBuilder(new String(chars));
		StringBuilder result = new StringBuilder();
		int cnt = 0;
		boolean begin = true;
		char add;
		while(sb.length() > 0) {
			cnt = 0;
			begin = true;
			while(cnt < sb.length()) {
				if(begin) {
					begin = false;
					add = sb.charAt(cnt);
					if(add >= 48 && add <= 57 || add >=97 && add <= 122) {
					result.append(add);
					sb.deleteCharAt(cnt);
					continue;
					} else {
						System.out.println("<invalid input string>");
						return ;
					}
				}
				if(result.charAt(result.length() - 1) == sb.charAt(cnt)) {
					cnt++;
					continue;
				} else {
					add = sb.charAt(cnt);
					if(add >= 48 && add <= 57 || add >=97 && add <= 122) {
					result.append(add);
					sb.deleteCharAt(cnt);
					} else {
						System.out.println("<invalid input string>");
						return ;
					}
				}
			}
		}
		 System.out.println(result.toString());
	}
	
	public static void test(int n, int m, int k) {
		int l = 1;
		int j = 0;
		for(int i =1; i < m; i++) {
			l = l << 1;
			l = l | 1;
		}
		for(int i = m + n - 1; i >= n; i--) {
			j = j | 1 << i;
		}
		int count = 1;
		while(count < k && l < j) {
			if(countOne(++l) == m ) {
				count++;
			}
		}
		if(count != k) {
			System.out.println("Impossible");
		} else {
			StringBuilder pre = new StringBuilder();
			String tt = Integer.toBinaryString(l);
			int cnt = 0;
			for(int i = 0; i < tt.length(); i++) {
				if(tt.charAt(i) == '0') {
					cnt++;
				}
			}
			while(cnt < n) {
				pre.append(0);
				cnt++;
			}
			System.out.println(pre.append(tt));
		}
		
	}
	
	public static int countOne(int num) {
		int count = 0;
		while(num > 0) {
			if((num &1) ==1) // 当前位是1
				count++ ; // 计数器加1
			num >>=1 ; // 移位
		}
		return count;
	}
	
	public static int mSort(int []a, int begin, int end) {
		if(begin < end) {
			int middle = (begin + end) / 2;
			mSort(a, begin, middle);
			mSort(a, middle + 1, end);
			merge(a, begin, middle + 1, end);
			return sum;
		}
		return 0;
	}
	
	public static int merge (int []a, int begin, int middle, int end) {
		int right = middle;
		int left = begin;
		int []b = new int[end - begin + 1];
		int i = 0;
		while(left < middle && right <= end) {
			if(a[left] < a[right]) {
				b[i] = a[left];
				i++;
				left++;
			} else {
				b[i] = a[right];
				i++;
				right++;
				sum += middle - left;
			}
		}
		
		while(left < middle) {
			b[i++] = a[left++];
		}
		
		while(right <= end) {
			b[i++] = a[right++];
		}
		
		for(i = 0; i < b.length; i++) {
			a[begin + i] = b[i];
		}
		return sum;
	}
	


	
}

class a <T>{
	int i = 1;
}
