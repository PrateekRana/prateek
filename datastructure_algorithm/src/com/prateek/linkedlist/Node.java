package com.prateek.linkedlist;

public class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	void appendToTail(int data) {
		Node node = new Node(data);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = node;

	}

}
