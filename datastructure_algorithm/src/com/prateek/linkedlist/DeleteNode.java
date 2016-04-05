package com.prateek.linkedlist;

public class DeleteNode {
	
	void deleteGivenNode(Node n){
		Node next = n.getNext();
		n.setData(next.getData());
		n.setNext(n.getNext().getNext());
		
	}
	
	Node deleteNodeWhenDataisGiven(Node head,int d){
		
		if(head.getData() == d){
			return head.getNext();
		
		}while(head.getNext()!=null){
			
			if(head.getNext().getData() == d){
			
				head.setNext(head.getNext().getNext());
				return head;
			}
			head = head.getNext();
		}
		return head;
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		n.setNext(new Node(2));
		n.next.setNext(new Node(3));
		n.next.next.setNext(new Node(4));
		DeleteNode dn = new DeleteNode();
	//	dn.deleteGivenNode(n.next.next);
		dn.deleteNodeWhenDataisGiven(n, 4);
		while(n!=null){
			
			System.out.println(n.getData());
			n = n.getNext();
		}
	}
}
