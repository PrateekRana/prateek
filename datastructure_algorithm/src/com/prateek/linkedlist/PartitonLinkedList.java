package com.prateek.linkedlist;

public class PartitonLinkedList {
	
	void partiton(Node root,int x){
		Node l1 = null;
		Node l2 = null;
		
		while(root!=null){
			Node next = root.getNext();
			if(root.getData() > x){
				root.setNext(l1);
				l1 = root;
			}else{
				root.setNext(l2);
				l2 = root;
			}
			root = next;
		}
		
	}

}
