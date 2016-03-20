package com.prateek.tree;

import java.util.HashMap;
import java.util.Map;

public class SmallestNodeAtGivenLevel {
	
	static Map<Integer, TreeNode> levelValueMap = new HashMap<>();
	public static void findSmallestNode(TreeNode node,int currentLevel,int level){
		
		if(node == null){
			return ;
		}
		if(currentLevel == level){
			if(levelValueMap.isEmpty()){
				levelValueMap.put(currentLevel,node);
			}else{
				TreeNode previousNode = levelValueMap.get(currentLevel);
				if(node.data < previousNode.data){
					levelValueMap.put(currentLevel,node);
				}
			}
			
		}
		
		findSmallestNode(node.left, currentLevel+1, level);
		findSmallestNode(node.right, currentLevel+1, level);
		
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(16);
		SmallestNodeAtGivenLevel.findSmallestNode(node, 0, 2);
		TreeNode result = SmallestNodeAtGivenLevel.levelValueMap.get(2);
		System.out.println(result.data);
		
	}

}
