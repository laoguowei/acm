package com.chapter5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GraphAlg {

	/**
	 * @param args
	 */
	
	static final int MAX_VALUE = 100000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] mat = new int[7][7];
//		for(int i = 0; i < 7; i++)
//			for(int j = 0; j < 7; j++)
//				mat[i][j] = MAX_VALUE;
//		mat[0][1] = 2;
//		mat[0][3] = 1;
//		mat[1][3] = 3;
//		mat[1][4] = 10;
//		mat[2][5] = 5;
//		mat[2][0] = 4;
//		mat[3][4] = 2;
//		mat[3][6] = 4;
//		mat[3][5] = 8;
//		mat[3][2] = 2;
//		mat[4][6] = 6;
//		mat[6][5] = 1;
//		int[] min = new int[7];
//		GraphAlg.dijkstra(mat, 0, min, null, 7);
//		for(int i = 0; i < 7; i++) {
//			System.out.println(min[i]);
//		}
//		int T;
//		int[][] a;
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			T = sc.nextInt();
//			if(T == 0) {
//				break;
//			}
//			a = new int[T][T] ;
//			for(int i = 0 ; i < T; i++)
//				for(int j = 0; j < T; j++)
//					a[i][j] = MAX_VALUE;
//			for(int i = 0; i < T ; i++) {
//				int pairs = sc.nextInt();
//				for(int j = 0; j < pairs; j++) {
//					int pNum = sc.nextInt();
//					int time = sc.nextInt();
//					a[i][pNum - 1] = time;
//				}
//			}
//			int[] min = new int[T];
//			int minTime = 10000;
//			int max = 0;
//			int p = 0;
//			for(int i = 0; i < T; i++) {
//				dijkstra(a, i, min, null, T);
//				max = 0;
//				for(int j = 0; j < T; j++) {
//					if(min[j] > max ) {
//						max = min[j];
//					}
//				}
//				if(minTime > max) {
//					minTime = max;
//					p = i + 1;
//				}
//			}
//			System.out.println(p + " " + minTime);
//		}
		int[][] mat = new int [7][7];
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 7; j++)
				mat[i][j] = 1 << 30;
		mat[0][1] = 2;
		mat[0][2] = 4;
		mat[0][3] = 1;
		mat[1][0] = 2;
		mat[1][3] = 3;
		mat[1][4] = 10;
		mat[2][0] = 4;
		mat[2][3] = 2;
		mat[2][5] = 5;
		mat[3][2] = 2;
		mat[3][0] = 1;
		mat[3][1] = 3;
		mat[3][4] = 7;
		mat[3][5] = 8;
		mat[3][6] = 4;
		mat[4][1] = 10;
		mat[4][3] = 7;
		mat[4][6] = 6;
		mat[5][2] = 5;
		mat[5][3] = 8;
		mat[5][6] = 1;
		mat[6][3] = 4;
		mat[6][4] = 6;
		mat[6][5] = 1;
		int total = GraphAlg.primAlg(mat, 7, null);
		System.out.print(total);
	}
	
	public static void dijkstra(int[][] mat, int s, int[] min, int[] pre, int n) {
		int[] visit = new int[n];
		for(int i = 0; i < n; i++) {
			min[i] =MAX_VALUE;
			visit[i] = 0;
			if(mat[s][i] < MAX_VALUE) {
				min[i] = mat[s][i];
			}
		}
		min[s] = 0;
		visit[s] = 1;
		for(int i = 0; i < n; i++) {
			int minLen = MAX_VALUE;
			int k = s;
			for(int j = 0; j < n; j++) {
				if(visit[j] ==0 && min[j] < minLen) {
					k = j;
					minLen = min[j];
				}
			}
			visit[k] = 1;
			for(int j = 0; j < n; j++) {
				if(visit[j] == 0 && min[j] > mat[k][j] + min[k]) {
					min[j] = mat[k][j] + min[k];
				}
			}
		}
	}
	
	public static int primAlg(int[][] mat, int n,int[][] path) {
		int[] visit = new int[n];
		int lowcost[] = new int[n];
		int closet[] = new int[n];
		Arrays.fill(lowcost, 1 << 30);
		Arrays.fill(visit, 0);


		int known = 2;
		lowcost[known] = 0;
		visit[known] = 1;
		int nextKnown = 0;
		int ans = 0;
		for(int i = 1; i < n; i++) {
			int minCost = 1 << 30;
				for(int j = 0; j < n; j++) {
					if(visit[j] == 0) {
						int tmp = mat[known][j];
						if(tmp < lowcost[j]) {
							lowcost[j] = tmp;
							closet[j] = known;
						}
						if(lowcost[j] < minCost) {
							minCost = lowcost[j];
							nextKnown = j;
						}
					}
				}
			ans += minCost;	
			visit[known = nextKnown] = 1;
		}
		return ans;
	}
}
