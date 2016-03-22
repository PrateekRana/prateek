package com.prateek.tree;

public class FirstCommonAncestor {

	boolean covers(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}

		return covers(root.left, p) || covers(root.right, p);
	}

	TreeNode findAncestor(TreeNode root,TreeNode p,TreeNode q){
		
		if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		
		if(is_p_on_left != is_q_on_left){
			return root;
		}
		
		TreeNode child_tree = is_p_on_left?root.left:root.right;
		return findAncestor(child_tree, p, q);
		
		
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.left.left = new TreeNode(8);
		node.left.right = new TreeNode(4);
		node.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		FirstCommonAncestor fc = new FirstCommonAncestor();
		TreeNode result = fc.findAncestor(node,node.left.left,node.left.left.left);
		System.out.println(result.data);
		
	}

}
