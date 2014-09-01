package com.chapter5;

import java.util.Random;

public class InsertionSort {
	
	public static void insertionSort(int []a) {
		int j;
		for(int i = 1; i < a.length; i++) {
			int tmp = a[i];
			for(j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
	
	public static void bubbleSort(int []a){
		for(int i = 0; i < a.length; i ++){
			for(int j = a.length - 1; j >i; j --){
				if (a[j-1] > a[j] ){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}	
	}
	
	public static void selectionSort(int []a) {
		for(int i = 0; i < a.length; i ++) {
		    int k = i;
			for(int j = i; j < a.length; j++) {
				if(a[j] < a[k])
				k = j;
			}
			int tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
		}
	}
	
	public static int partition(int[] a, int start, int end){
		Random random = new Random();
		
		int length = end - start + 1;
		int pirot = random.nextInt(length) + start;
		
		int temp = a[pirot];
		a[pirot] = a[start];
		a[start] = temp;
		int small = start;
		for(int index = start + 1; index <= end; index ++){
			if (a[index] < a[start]){
				small ++;
				if (small < index){
					temp = a[small];
					a[small] = a[index];
					a[index] = temp;
				}
			}
		}
		temp = a[small];
		a[small] = a[start];
		a[start] = temp;
		return small;
//		while(start < end){
//			while(start < end && a[start] < key){
//				start ++;
//			}
//			a[pirot] = a[start];
//			pirot = start;
//			while(start < end && a[end] > key){
//				end --;
//			}
//			a[pirot] = a[end];
//			pirot = end;
//		}
//		a[pirot] = key;
//		return pirot;
	}
	
	public static void quickSort(int[] a, int start, int end){
		if (start < end){
			int pirot = partition(a, start, end);
			quickSort(a,start,pirot -1);
			quickSort(a,pirot + 1,end);
		}
	}
	
	public static void merge(int a[], int begin, int end, int middle) {
		int rightStart = middle;
		int left = begin;
		int right = end;
		int []tmp = new int [right - left + 1];
		int i = 0;
		while(left < middle && rightStart <= right ) {
			if(a[left] < a[rightStart]) {
				tmp[i++] = a[left++];
			} else {
				tmp[i++] = a[rightStart++];
			}			
		}
		while(left < middle) {
			tmp[i++] = a[left++];
		}
		while(rightStart <= right) {
			tmp[i++] = a[rightStart++];
		}
		for(int j = 0; j< tmp.length; j++) {
			a[begin + j] = tmp[j];
		}
	}
	
	public static void mergeSort(int []a, int begin, int end) {
		if(begin < end) {
			int middle = (begin + end) / 2;
			mergeSort(a, begin, middle);
			mergeSort(a,middle + 1, end);
			merge(a, begin, end, middle + 1);
		}
	}
}


