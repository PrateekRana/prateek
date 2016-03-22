package com.prateek.linkedlist;

public class ReverserLinkedList {
	Node head;
	
	void reverse(Node node,Node previous){
		
		if(node.next == null){
			head = node;
			node.next = previous;
			return;
		}
		
		Node current = node.next;
		Node n = node;
		n.next = previous;
		reverse(current, n);
	}
	
	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		ReverserLinkedList rs = new ReverserLinkedList();
		rs.reverse(n,null);
		while(rs.head!=null){
			
			System.out.println(rs.head.data);
			rs.head = rs.head.next;
		}
	}

}
