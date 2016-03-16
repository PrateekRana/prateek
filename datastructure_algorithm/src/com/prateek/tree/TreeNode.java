package com.prateek.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TreeNode {

	int data;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	static Random random = new Random();

	 @Override
	    public String toString() {
	        // Tells if this node is on left or right side side of parent
	        String label = parent == null ? "" : this == left ? "-L" : "-R";
	        return data + label;
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

	public static Map<TreeNode, List<TreeNode>> asMap(TreeNode root) {
		Map<TreeNode, List<TreeNode>> toReturn = new HashMap<>();
		asMapHelper(root, toReturn);
		return toReturn;
	}

	private static  void asMapHelper(TreeNode node, Map<TreeNode, List<TreeNode>> map) {
		if (node == null) {
			return;
		}
		List<TreeNode> list = new ArrayList<>();
		if (node.left != null) {
			list.add(node.left);
		}
		if (node.right != null) {
			list.add(node.right);
		}
		map.put(node, list);
		asMapHelper(node.left, map);
		asMapHelper(node.right, map);
	}

	public static void main(String[] args) {
		TreeNode node = constructTree(2); 
		GraphViewer.viewGraph(node);
		System.out.println(TreeNode.constructTree(2));
	}

}
