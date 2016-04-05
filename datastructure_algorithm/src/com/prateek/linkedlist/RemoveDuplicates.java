package com.prateek.linkedlist;

public class RemoveDuplicates {

	void remove(Node head){
		Node current = head;
		while(current!=null){
			Node runner = current;
			while(runner.getNext()!=null){
				if(current.getData() == runner.getNext().getData()){
					runner.setNext(runner.getNext().getNext());
				}else{
					runner = runner.getNext();
				}
			}
			current = current.getNext();
		}
	}
}