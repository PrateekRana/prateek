package com.prateek.linkedlist;

public class PartitonLinkedList {
	
	void partiton(Node root,int x){
		Node l1 = null;
		Node l2 = null;
		
		while(root!=null){
			Node next = root.next;
			if(root.data > x){
				root.next = l1;
				l1 = root;
			}else{
				root.next = l2;
				l2 = root;
			}
			root = next;
		}
		
	}

}
