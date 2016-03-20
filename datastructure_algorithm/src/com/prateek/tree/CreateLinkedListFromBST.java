package com.prateek.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateLinkedListFromBST {

	static void createLinkedList(TreeNode t, List<LinkedList<TreeNode>> list, int level) {

		LinkedList<TreeNode> linkedList = null;
		if (t == null) {
			return;
		}
		if (list.size() == level) {
			linkedList = new LinkedList<>();
			list.add(linkedList);
		} else {
			linkedList = list.get(level);
		}
		linkedList.add(t);
		createLinkedList(t.left, list, level+1);
		createLinkedList(t.right, list, level+1);
	}

	static List<LinkedList<TreeNode>> createLevelLikedList(TreeNode t) {

		List<LinkedList<TreeNode>> list = new ArrayList<>();
		createLinkedList(t, list, 0);
		return list;

	}
	
	
}
