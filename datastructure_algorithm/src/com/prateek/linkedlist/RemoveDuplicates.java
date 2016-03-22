package com.prateek.linkedlist;

public class RemoveDuplicates {

	void remove(Node head){
		Node current = head;
		while(current!=null){
			Node runner = current;
			while(runner.next!=null){
				if(current.data == runner.next.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
