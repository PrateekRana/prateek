package com.prateek.linkedlist;

public class DeleteNode {
	
	void deleteGivenNode(Node n){
		Node next = n.next;
		n.data = next.data;
		n.next = n.next.next;
		
	}
	
	Node deleteNodeWhenDataisGiven(Node head,int d){
		
		if(head.data == d){
			return head.next;
		
		}while(head.next!=null){
			
			if(head.next.data == d){
			
				head.next = head.next.next;
				return head;
			}
			head = head.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		DeleteNode dn = new DeleteNode();
	//	dn.deleteGivenNode(n.next.next);
		dn.deleteNodeWhenDataisGiven(n, 4);
		while(n!=null){
			
			System.out.println(n.data);
			n = n.next;
		}
	}
}
