package com.prateek.tree;

public class SubTree {
	
	boolean isSubTree(TreeNode root,TreeNode r){
		if(root == null){
			return false;
		}
		
		if(root.data == r.data){
			if(matchTree(root, r))
				return true;
		}
		
		return isSubTree(root.left, r) || isSubTree(root.right, r);
	}
	
	boolean matchTree(TreeNode root, TreeNode r){
		
		if(root==null && r == null){
			return true;
		}
		if(root==null || r == null){
			return false;
		}
		if(root.data!=r.data){
			return false;
		}
		
		return (matchTree(root.left, r.left) && matchTree(root.right, r.right));
	}

}
