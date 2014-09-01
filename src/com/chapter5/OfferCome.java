package com.chapter5;

import java.math.BigDecimal;

public class OfferCome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		
		//System.out.print(OfferCome.searchInMatrix(a, , 3, 3));
		//OfferCome.
		
	}
	
	//字符串转整数
	public static int stringToInteger(String s) throws Exception {
		if (s.isEmpty()) {
			throw new NumberFormatException("null");
		}
		int result = 0;
		int dec = 1;
		for(int i = s.length() - 1; i >0; i--) {
			if(s.charAt(i) < 48 || s.charAt(i) > 58) {
				throw new Exception("string is not number");
			}
			result += (s.charAt(i) - 48) * dec;
			dec *= 10;
			if (result < 0) {
				throw new Exception("over flow");
			}
		}
		if((s.charAt(0) > 58 || s.charAt(0) < 48) && s.charAt(0) != '-' ) {
			throw new Exception("not a number");
		}
		if(s.charAt(0) == '-') {
			return -result;
		} 
		return result += dec*10*(s.charAt(0) - 48);
	}
	
	//二维数组中的查找
	public static boolean searchInMatrix(int [][]a, int num, int col, int row) {
		int i = col;
		int j = 0;
		while(i >= 0 && j <= row) {
			if(a[j][i] > num) {
				i--;
				continue;
			} 
			if(a[j][i] < num) {
				j++;
				continue;
			}
			if(a[j][i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void replaceString(int [] bigger, int [] smaller, int curr) {
		int blen = bigger.length - 1;
		int slen = smaller.length - 1;
		while(curr >= 0 && slen >= 0) {
			if(bigger[curr] > smaller[slen]) {
				bigger[blen--] = bigger[curr];
				curr--;
			} else {
				bigger[blen--] = smaller[slen--];
			}
		}
		while(curr >= 0) {
			bigger[blen--] = bigger[curr--];
		}
		while(slen >= 0) {
			bigger[blen--] = smaller[slen--];
		}
		return;
	}
	
	//打印 0~n位数
	public static void printN(int n) {
		
	}

}
