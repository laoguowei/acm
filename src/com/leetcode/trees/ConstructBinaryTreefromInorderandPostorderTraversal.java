package com.leetcode.trees;

import com.leetcode.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromInorderandPostorderTraversal test = new ConstructBinaryTreefromInorderandPostorderTraversal();
		test.buildTree(new int[]{2,1}, new int[]{2,1});
	}
	
	/*
	 * 由中序和后序遍历的顺序构造二叉树。
	 * 由后序顺序可以知道根节点的值，然后由中序可以知道左子树的值是哪些，右字数的值是哪些。递归做就可以了
	 * 由于要递归，所有参数还要再多4个。
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 0) return null;
		TreeNode root = buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
		return root;
	}
    public TreeNode buildTree(int[] inorder, int[] postorder, int inB, int inE, int pB, int pE) {
    	if(inB > inE) return null;//这一句比较重要在[2,1] [2,1]的输入的时候
        if(inB == inE) return new TreeNode(inorder[inB]);
        TreeNode root = new TreeNode(postorder[pE]);
        int count = 0;
        for(; count <= inE; count++) {
        	if(inorder[count + inB] == postorder[pE]) break;
        }
        
        TreeNode left = buildTree(inorder, postorder, inB, count + inB - 1, pB, pB + count - 1);
        TreeNode right = buildTree(inorder, postorder, count + inB + 1, inE, count + pB, pE - 1);
        root.left = left;
        root.right = right;
        return root;
        
    }

}
