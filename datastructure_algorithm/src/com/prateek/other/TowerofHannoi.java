package com.prateek.other;

public class TowerofHannoi {
	
	public static void main(String[] args) {
		int n = 3;
		TowerofHannoi.doTowers(n,'A', 'B', 'C');
	}
	
	public static void doTowers(int top,char from,char inter,char to){
		if(top == 1){
			System.out.println("Disk"+top+"from"+from+"to"+to);
		}else{
			doTowers(top-1, from, to,inter);
			System.out.println("Disk"+top+"from"+from+"to"+to);
			doTowers(top-1,inter,from,to);
		}
		
	}
	

}
