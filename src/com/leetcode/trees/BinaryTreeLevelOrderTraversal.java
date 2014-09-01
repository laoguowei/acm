package com.leetcode.trees;

import java.util.LinkedList;
import java.util.List;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("3,9,20,#,#,15,7");
		BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
		test.levelOrderBottom(root);
	}
	/*
	 * 将树的内容按照层序输出，一层输出到一个链表中
	 * 由于每一层要单独输出，所以得用两个队列来做，一个队列保存当前输出的元素。一个队列保存下一个轮要输出的元素
	 * 元素输出完后，将两个队列的引用调换位置即可重新开始。如果两个队列都为空，则输出结束。
	 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList();
        if(root == null) return result;
        queue1.add(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
        	LinkedList<Integer> container = new LinkedList<Integer>();

        	while(!queue1.isEmpty()) {
        		TreeNode tmpNode = queue1.removeFirst();
        		if(tmpNode.left != null) queue2.addLast(tmpNode.left);
        		if(tmpNode.right != null)queue2.addLast(tmpNode.right);
        		container.addLast(tmpNode.val);
        	}
        	((LinkedList) result).addFirst(container);
        	LinkedList<TreeNode> tmp = queue1;
        	queue1 = queue2;
        	queue2 = tmp;
        }
        return result;
    }

}
