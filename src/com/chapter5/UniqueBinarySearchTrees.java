package com.chapter5;

public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees.numTrees(1);
	}
	
    public static int numTrees(int n) {
    	int []f = new int[n + 1];
    	f[0] = 1;
    	f[1] = 1;
        for(int i = 1; i < n; i ++) {
        	int tmp = 0;
        	for(int j = 0; j <= i; j++) {
        		tmp += f[i-j]*f[j];
        	}
        	f[i +1] = tmp;
        }
        return f[n];
    }

}
