package com.xm.demo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		AtomicInteger count = new AtomicInteger(1);
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			pool.submit(new Runnable() {
				@Override
				public void run() {
					lock.lock();
					int number = count.getAndIncrement();
					System.out.println(String.format("我是线程：%d get到锁，执行同步逻辑...",number));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.unlock();
				}
			});
		}
	}
}
