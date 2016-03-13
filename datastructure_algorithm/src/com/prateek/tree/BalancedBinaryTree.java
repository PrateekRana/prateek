package com.prateek.tree;

public class BalancedBinaryTree {
	
	boolean isBalanced(TreeNode n){
		
		if(n == null){
			return true;
		}
		int heighLeft = TreeNode.height(n.left);
		int heightRight = TreeNode.height(n.right);
		int difference = heighLeft - heightRight;
		if(difference > 1){
			return false;
		}else{
			return isBalanced(n.left) && isBalanced(n.right);
		}
		
	}

}
