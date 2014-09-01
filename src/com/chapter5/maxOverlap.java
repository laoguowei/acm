package com.chapter5;

public class maxOverlap {
	
	public static void main(String args[]){
		String s = "aacaagmtttacaagmc";
		System.out.println(getMaxOverlapSub(s));
	}
	  
	  public static int getMaxOverlapSub(String s) {
		  char[] chars = s.toCharArray();
		  int i, j;
		  int max = 0;
		  for(i = 0; i < s.length(); i++) {
			  char begin = chars[i];
			  int cnt = i;
			  int count = 0;
			  boolean equalBegin = false;
			  for(j = i + 1; j < s.length(); j++) {
				  if(!equalBegin) {
					  if(begin != chars[j]) {
						  continue;
					  }
				  }
				  equalBegin = true;
				  if(chars[cnt++] == chars[j]) {
					  count++;
					  if(j == s.length() - 1) {
						  if(count > max) {
							  max = count;
						  }
					  }
				  } else {
					  equalBegin = false;
					  if(count > max) {
						  max = count;
					  }
					  count = 0;
					  cnt = i;
				  }
			  }
		  }
		  return max;
	  }
}
