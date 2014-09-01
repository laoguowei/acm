package com.chapter5;

public class MyLinkedList {

	/**
	 * @param args
	 */
	Node head = new Node();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MyLinkedList ml1 = new MyLinkedList();
			MyLinkedList ml2 = new MyLinkedList();
			ml1.add(7);
			ml1.add(5);
			ml1.add(3);
//			ml1.add(1);
//			ml2.add(8);
//			ml2.add(6);
//			ml2.add(4);
//			ml2.add(2);
			ml1.head = MyLinkedList.mergeList(ml1.head.next, ml2.head.next);
			ml1.printFromLast(ml1.head.next);
			
	}
	
	static class Node {
		Node next;
		int ele;
		public Node() {
			next = null;
		}
	}
	
	public void add(int ele) {
		MyLinkedList.Node newNode = new MyLinkedList.Node();
		newNode.ele = ele;
		newNode.next = this.head.next;
		this.head.next = newNode;
	}
	
	public void printFromLast(MyLinkedList.Node node) {
		if(node.next != null) {
			printFromLast(node.next);
		}
		System.out.println(node.ele);
	}
	
	public Node reverseList(Node head) {
		Node preNode;
		Node currNode;
		Node nextNode;
		if(head.next == null || head.next.next == null )
			return head;
		else {
			Node lastNode = head.next;
			preNode = head.next;
			currNode = preNode.next;
			nextNode= currNode.next;
			while(nextNode != null) {
				currNode.next = preNode;
				preNode = currNode;
				currNode = nextNode;
				nextNode = nextNode.next;
			}
			currNode.next = preNode;
			head.next = currNode;
			lastNode.next = null;
			return head;
		}
	}
	
	public static Node mergeList(Node listNodeA, Node listNodeB) {
		Node newHead = new Node();
		Node a = listNodeA;
		Node b = listNodeB;
		Node cur = newHead;
		while(a != null && b != null) {			
			if(a.ele < b.ele) {
				cur.next = a;
				a = a.next;
				cur = cur.next;
			} else {
				cur.next = b;
				b = b.next;
				cur = cur.next;
			}
		}
		if(a != null) {
			cur.next = a;
		}
		if(listNodeB != null) {
			cur.next = b;
		}
		return newHead;
	}

}
