package com.prateek.tree;

public class FindPathsEqualsToGivenValue {

	static void findSum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) {
			return;
		}
		path[level] = node.data;
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
	}

	public static void findSum(TreeNode node, int sum){
		int depth = TreeNode.height(node);
		int[] path = new int[depth];
		findSum(node, sum,path,0);
	}
	
	static void print(int[] path,int start,int end){
		for(int i = start;i<=end;i++){
			System.out.println(path[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		FindPathsEqualsToGivenValue.findSum(node, 6);
		GraphViewer.viewGraph(node);
		
	}
	
	
}
