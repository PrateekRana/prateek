package com.prateek.tree;

import java.util.Arrays;

public class BSTFromArray {

	static TreeNode constructBSTFromGivenArray(int[] array,int startIndex,int lastIndex) {
	//	Arrays.sort(array);
		if(lastIndex < startIndex){
			return null;
		}
		int middle = (startIndex+lastIndex)/2;
		TreeNode node = new TreeNode();
		node.data = array[middle];
		node.left = constructBSTFromGivenArray(array,startIndex,middle-1);
		node.right = constructBSTFromGivenArray(array,middle+1,lastIndex);
		return node;
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,6,8,9,10};
		GraphViewer.viewGraph(BSTFromArray.constructBSTFromGivenArray(array,0,array.length-1));
	}
}
