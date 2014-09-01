package com.chapter5;

import java.util.Stack;

public class BinaryTree {

	/**
	 * @param args
	 */
	
	static Stack in = new Stack();
	static Stack out = new Stack();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int a[] = {1,2,4,7,3,5,6,8};
//		int b[] = {4,7,2,1,5,3,8,6};
//		BinaryTree.node root = new node();
//		BinaryTree.restruction(root, a, b, 0, a.length - 1, 0, b.length - 1);
////		for(int i = 0; i < a.length; i++) {
////			root = BinaryTree.insert(a[i], root);
////		}
////		
//		BinaryTree.lasPrint(root);
//		for(int i = 0; i < 9 ; i++)
//			BinaryTree.add(i);
//		for(int i = 0; i < 9 ; i++)
//			System.out.println(BinaryTree.out());
		int a[] = {6,7,8,12,23,56,59,60,63,5};
		System.out.println(BinaryTree.rotateArray(a));
	}
	
	public static BinaryTree.node insert(int num, BinaryTree.node node) {
		if(node ==null) {
			node = new node();
			node.setEle(num);
			node.setLeftChild(null);
			node.setRightChid(null);
			return node;
		}
		if(num < node.getEle()) {
			node.setLeftChild(insert(num, node.getLeftChild()));
			return node;
		} else {
			node.setRightChid(insert(num, node.getRightChid()));
			return node;
		}
	}
	
	public static void midPrint(BinaryTree.node rt) {
		if(rt != null) {
			midPrint(rt.getLeftChild());
			System.out.println(rt.getEle());
			midPrint(rt.getRightChid());
		}
	}
	
	public static void prePrint(BinaryTree.node rt) {
		if(rt != null) {
			System.out.println(rt.getEle());
			prePrint(rt.getLeftChild());
			prePrint(rt.getRightChid());
		}
	}
	
	public static void lasPrint(BinaryTree.node rt) {
		if(rt != null) {

			lasPrint(rt.getLeftChild());
			lasPrint(rt.getRightChid());
			System.out.println(rt.getEle());
		}
	}
	
	static class node {
		node leftChild;
		node rightChid;
		int ele;
		public node getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(node leftChild) {
			this.leftChild = leftChild;
		}
		public node getRightChid() {
			return rightChid;
		}
		public void setRightChid(node rightChid) {
			this.rightChid = rightChid;
		}
		public int getEle() {
			return ele;
		}
		public void setEle(int ele) {
			this.ele = ele;
		}
		
	}
	//由前序遍历和中序遍历确定树结构
	public static void restruction(BinaryTree.node node, 
			int[] pre, 
			int []mid, 
			int preS, 
			int preE, 
			int midS,
			int midE) {
		if(preS < preE) {
			
			int rootEle = pre[preS];
			node.ele = rootEle;
			int i;
			for(i = midS; i <= midE; i++) {
				if(mid[i] == rootEle) {
					break;
				}
			}
			int leftEles = i - midS;
			int rightEles = midE - i;
			if(leftEles != 0) {
				BinaryTree.node leftChild = new node();
				node.leftChild = leftChild;
				restruction(leftChild, pre, mid, preS + 1, preS + leftEles, midS, i - 1);
			} 
			if(rightEles != 0) {
				BinaryTree.node rightChild = new node();
				node.rightChid = rightChild;
				restruction(rightChild, pre, mid, preS + leftEles + 1, preE, i + 1, midE);	
			}
		} else {
			node.ele = pre[preS];
			node.setLeftChild(null);
			node.setRightChid(null);
		}
	}
	
	
	//两个栈实现队列
	public static void add(int ele) {
		in.push(ele);
	}
	
	public static int out() {
		if(out.size() > 0) {
			return (Integer)out.pop();
		}
		int size = in.size();
		for(int i = 0; i < size; i++) {
			out.push(in.pop());
		}
		int re = (Integer)out.pop();
		return re;
	}
	
	//查找旋转数组最小值(输入11101时有bug)
	public static int rotateArray(int []a) {
		int start = 0;
		int end = a.length - 1;
		int mid = (start + end) / 2;

		while(start < end) {
			if(a[start] < a[end]) {
				return a[start];
			}
			
			if(a[mid] >= a[start]) {
				start = mid + 1;
				mid = (start + end) /2;
				
				continue;
			} 
			if(a[mid] < a[end]) {
				end = mid;
				mid = (mid + start) / 2;
				continue;
			}
		}
		return a[start];
	}

}
