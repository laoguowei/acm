package com.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class TreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a ={0,0,0,};
		sumZero(a, 1);
	}
	
	public static int sumZero(int []a, int target) {
		Arrays.sort(a);
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length; i++) {
			int k = a.length - 1;
			for(int j = i + 1; j < k;) {
				if(a[i] + a[j] + a[k] < target) {					
					if(Math.abs(a[i] + a[j] + a[k] - target) < min) {
						min = Math.abs(a[i] + a[j] + a[k] - target);
						sum = a[i] + a[j] + a[k];
					}
					j++;
				} else if(a[i] + a[j] + a[k] > target) {
					if(Math.abs(a[i] + a[j] + a[k] - target) < min) {
						min = Math.abs(a[i] + a[j] + a[k] - target);
						sum = a[i] + a[j] + a[k];
					}
					k--;
				} else {
					return target;
				}
			}
		}
		return sum;
	}
}
