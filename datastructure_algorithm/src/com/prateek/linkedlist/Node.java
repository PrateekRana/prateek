package com.prateek.linkedlist;

public class Node {
	 int data;
	 Node next;

	public Node(int data) {
		this.setData(data);
	}

	void appendToTail(int data) {
		Node node = new Node(data);
		Node n = this;
		while (n.getNext() != null) {
			n = n.getNext();
		}
		n.setNext(node);

	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
