package com.prateek.tree;

public class CheckBST {

	static boolean isBST(TreeNode t) {
		if (t == null) {
			return true;
		}
		int data = t.data;
		if (t.left != null && t.left.data > data) {
			return false;
		}
		if (t.right != null && t.right.data < data) {
			return false;
		}
		isBST(t.left);
		isBST(t.right);
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,6,8,9,10};
		TreeNode t = BSTFromArray.constructBSTFromGivenArray(array, 0,array.length-1);
		
		System.out.println(CheckBST.isBST(t));
	}

}
