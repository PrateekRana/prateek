package com.prateek.tree;

import java.util.Random;

import lt.monarch.graph.GraphView;

public class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;
	static Random random = new Random();

	@Override
	public String toString() {
		return "[data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	static TreeNode constructTree(int depth) {

		if (depth == -1) {
			return null;
		}
		TreeNode node = new TreeNode();
		node.data = getInteger();
		node.left = constructTree(depth - 1);
		node.right = constructTree(depth - 1);
		return node;

	}

	static int height(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return Math.max(height(node.left), height(node.right)) + 1;
	}

	static int getInteger() {
		int data = Math.abs(random.nextInt() % 100);
		return data;
	}

	public static void main(String[] args) {
		System.out.println(TreeNode.constructTree(2));
	}

}
