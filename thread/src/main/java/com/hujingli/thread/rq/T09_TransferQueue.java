package com.hujingli.thread.rq;

import java.util.concurrent.LinkedTransferQueue;

public class T09_TransferQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
		
		Thread c1 = new Thread(() -> {

			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread c2 = new Thread(() -> {
			c1.start();
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread p1 = new Thread(() -> {

			try {
				strs.transfer("p1");
				System.out.println("p1被取走了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread p2 = new Thread(() -> {
			p1.start();
			try {
				strs.transfer("p2");
				System.out.println("p2被取走了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		c2.start();
		p2.start();



		
		//strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


	}
}
