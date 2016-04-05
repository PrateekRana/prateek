package com.prateek.linkedlist;

public class ReverserLinkedList {
	Node head;
	
	void reverse(Node node,Node previous){
		
		if(node.getNext() == null){
			head = node;
			node.setNext(previous);
			return;
		}
		
		Node current = node.getNext();
		Node n = node;
		n.setNext(previous);
		reverse(current, n);
	}
	
	public static void main(String[] args) {
		Node n = new Node(1);
		n.setNext(new Node(2));
		n.next.setNext(new Node(3));
		n.next.next.setNext(new Node(4));
		ReverserLinkedList rs = new ReverserLinkedList();
		rs.reverse(n,null);
		while(rs.head!=null){
			
			System.out.println(rs.head.getData());
			rs.head = rs.head.getNext();
		}
	}

}
