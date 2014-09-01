package com.chapter5;

import java.io.BufferedReader;
import java.util.Random;
import java.util.Scanner;

public class testQuikSort {

	/**
	 * @param args
	 */
	
	public static Random random = new Random();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= {56,11, 45, 89, 5, 3, 100,1};
		int aa[] = {1,3,5,7,9,2,4,6,8,10};
		//mSort(aa, 0, aa.length - 1);
		//System.out.println(testQuikSort.partition(0, a.length - 1, a));
		//testQuikSort.partition(0, a.length - 1, a);
//		testQuikSort.quickSort(a, 0, a.length - 1);
//		InsertionSort.insertionSort(a);
//		InsertionSort.mergeSort(aa, 0, aa.length - 1);
	//	testQuikSort.mergeSort(a, 0, a.length - 1);
		for(int i= 0; i < aa.length; i++) {
			System.out.print(aa[i] + " ");
		}
		int aaa[] = new int[4];
		//System.out.print(testQuikSort.findMax(aaa));
		//testQuikSort.listAll(aaa, 0, 4);
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		int n;
//		while(T-- > 0) {
//			n = sc.nextInt();
//			int aaaa[] = new int[n];
//			for(int i = 0; i < n; i++)
//				aaaa[i] = sc.nextInt();
//		}
	}
	
	public static void listAll(int []a, int cnt, int n) {
		if(cnt == a.length ) {
			for(int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
		else {
			for(int i = 1; i <= n; i++) {
				boolean ok = true;
				for(int j = 0; j<cnt ; j++) {				
					if(a[j] == i) {
						ok = false;
						break;
					}
				}
				if(ok) {
					a[cnt] = i;
					listAll(a, cnt + 1, n);
				}
			}
		}
	}
	public void f() {
		
	}
	public static int partition(int begin, int end, int []a) {
		int piro = a[begin];
		int tmp;
		while(begin < end) {
			while(piro < a[end] && begin < end) end--;
			tmp = a[end];
			a[end] = piro;
			a[begin] = tmp;
			while(piro > a[begin] && begin < end) begin++;
			tmp = a[begin];
			a[begin] = a[end];
			a[end] = tmp;
		}
		return begin;
	}
	
	public static void qSort(int []a, int begin, int end) {
		if(begin < end) {
			int middle = partition(begin, end, a);
			qSort(a, begin, middle - 1);
			qSort(a, middle + 1, end);
		}
	}
	
	public  void mSort(int []a, int begin, int end) {
		if(begin < end) {
			int middle = (end + begin) / 2;
			mSort(a, begin, middle);
			mSort(a, middle + 1, end);
			merge(a, begin, end, middle +1);
		}
	}
	
	public static void merge(int []a, int begin, int end, int middle) {
		int[] b = new int[end - begin + 1];
		int start = begin;
		int right = middle;
		int i = 0;
		while(begin < middle && right <= end) {
			if(a[begin] < a[right]) {
				b[i] = a[begin];
				begin++;
			} else {
				b[i] = a[right];
				right++;
			}
			i++;
		}
		while(begin < middle) {
			b[i] = a[begin];
			i++;
			begin++;
		}
		
		while(right <= end) {
			b[i] = a[right];
			i++;
			right++;
		}
		
		for(int j = 0; j < i; j++) {
			a[start + j] = b[j];
		}
	}
	
	
//	public static int partition(int begin, int end, int []a) {
//		int k = begin + random.nextInt(end - begin + 1);
//		int piro = a[k];
//		System.out.println("Ö÷Ôª£º" + piro + "begin:" + begin + " end:" + end);
//		a[k] = a[begin];
//		a[begin] = piro;
//		int loc = begin;
//		while(begin != end) {
//			while(a[end] >= piro && begin < end)
//				end--;
//			a[loc] = a[end];
//			a[end] = piro;
//			loc = end;
//			while(a[begin] <= piro && begin < end)
//				begin++;
//			a[loc] = a[begin];
//			a[begin] =piro;
//			loc = begin;
//		}
//		
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//		System.out.println();
//		return end;
//	}
//	
//	public static int findK(int k, int []a, int begin, int end) {
//		int loc = partition(begin, end, a);
//		if (loc == k)
//			return a[loc];
//		else {
//			if(loc < k) {
//				return findK(k, a, loc + 1, end);
//			} else {
//				
//				return findK(k, a, begin, loc - 1);
//			}
//		}
//	}
//	
//	public static void quickSort(int []a, int begin, int end) {
//		if (begin < end){
//			int piroLoc = partition(begin, end, a);		
//			quickSort(a, begin, piroLoc-1);
//			quickSort(a, piroLoc + 1, end);
//		}		
//	}
//	
//	public static void merge(int []a, int begin1, int begin2, int end) {
//		int start =begin1;
//		int middle = begin2;
//		int length = end - begin1 + 1;
//	    int []b = new int[length];
//	    
//	    for (int i = 0; i < length; i ++){
//           if (begin2 > end || (begin1 < middle && a[begin1] <= a[begin2])) {
//        	    b[i] = a[begin1];
//	    		begin1 ++;
//	    	}
//	    	else if (begin1 >= middle || (begin2 <= end && a[begin2] < a[begin1])){
//	    		b[i] = a[begin2];
//	    		begin2 ++;
//	    	}
//	    }
//	    
//	    for (int i = 0; i < length; i++){
//	    	a[start + i] = b[i];
//	    }
//	}
//	public static void mergeSort(int []a, int begin, int end) {
//		if (begin < end){
//			int middle = (begin + end) /2;
//			mergeSort(a, begin, middle);
//			mergeSort(a, middle + 1, end);
//			merge(a, begin, middle +1, end);	
//		}
//	}

}
