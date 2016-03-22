package com.prateek.linkedlist;

public class AddLinkedList {

	Node add(Node n1,Node n2,int carry){
		
		if(n1==null && n2==null && carry == 0){
			return null;
		}
		Node result = new Node(carry);
		int value = carry;
		if(n1!=null){
			value+=n1.data;
		}
		if(n2!=null){
			value+=n1.data;
		}
		result.data = value%10;
		
		if(n1!=null || n2!=null || value >=10){
			Node more = add(n1==null?null:n1.next,n2 == null?null:n2.next,value>=10?1:0);
			result.next = more;
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(2%5);
	}
	
	
}
