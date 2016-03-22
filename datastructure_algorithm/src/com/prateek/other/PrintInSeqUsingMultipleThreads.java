package com.prateek.other;

public class PrintInSeqUsingMultipleThreads extends Thread {

	int i = 1;

	@Override
	public void run() {
		synchronized (this) {
			
		
		while (i <= 20) {
			try {
				if (i % 5 == Integer.parseInt(Thread.currentThread().getName())) {
					System.out.println(Thread.currentThread().getName() + "---" + i);
					i = i+1;
					notifyAll();
					
				}else if(i%5 == 0 && Thread.currentThread().getName().equals("5")){
					System.out.println(Thread.currentThread().getName() + "---" + i);
					i = i+1;
					notifyAll();
				}else{
					wait();
				}
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	}
	

    public static void main(String[] args) {
    	PrintInSeqUsingMultipleThreads multi = new PrintInSeqUsingMultipleThreads();
        Thread t1 = new Thread(multi);
        Thread t2 = new Thread(multi);
        Thread t3 = new Thread(multi);
        Thread t4 = new Thread(multi);
        Thread t5 = new Thread(multi);
        t1.setName("1");
        t2.setName("2");
        t3.setName("3");
        t4.setName("4");
        t5.setName("5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
