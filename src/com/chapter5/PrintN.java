package com.chapter5;

public class PrintN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintN.print(10, "");
	}
	
	public static void print(int n, String sb) {
		if(n == 1) {
			int j = 0;
			int count = 0;
			while(j < sb.length()) {
				if(sb.charAt(j) != '0') {
					break;
				} else {
					count++;
				}
				j++;
			}
			if(count == sb.length()) sb = "";
			else sb = sb.substring(count);
			for(int i = 0; i <= 9; i++) {
				System.out.println(sb + i);
			}
			return;
		}
		for(int i = 0; i <= 9; i++) {
			print(n - 1, sb + i);
		}
	}

}
