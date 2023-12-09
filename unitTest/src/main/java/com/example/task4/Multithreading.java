package com.example.task4;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreading {
	private final ExecutorService executor=Executors.newFixedThreadPool(5);
	
	public CompletableFuture<String> processTask(String str){
		return CompletableFuture.supplyAsync(()->performTask(str),executor);
	}
	private String performTask(String input) {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return "process:" +input;
	}
	public void shutdown() {
		executor.shutdown();
	}

}
