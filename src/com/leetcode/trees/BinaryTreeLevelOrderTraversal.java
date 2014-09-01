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
	 * ���������ݰ��ղ��������һ�������һ��������
	 * ����ÿһ��Ҫ������������Ե�����������������һ�����б��浱ǰ�����Ԫ�ء�һ�����б�����һ����Ҫ�����Ԫ��
	 * Ԫ�������󣬽��������е����õ���λ�ü������¿�ʼ������������ж�Ϊ�գ������������
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
