package com.chapter5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c531 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="12345";
		int begin=Integer.parseInt(a);
		char []b=a.toCharArray();
		char []d=new char[b.length];
		Map myHash=new HashMap<Integer,Integer>();
		int max=0;
		int min=0;
		Integer result=0;
		while(true){
		Arrays.sort(b);
		for(int i=0;i<b.length;i++){
			d[i]=(char) (b[b.length-1-i]);
			}
		max=Integer.parseInt(String.valueOf(d));
		min=Integer.parseInt(String.valueOf(b));
		result=max-min;
		System.out.println(result);
		if(myHash.get(result)!=null)
			return ;
		myHash.put(result, result);
		b=result.toString().toCharArray();
	}
	
	}
	
	public static void test(int n){
		
	}

}
