package com.example.task4;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MultithreadingTest {
	private Multithreading service;
	
	@Before
	public void setUp() {
		service=new Multithreading();
	}
	@After
	public void tearDown() {
		service.shutdown();
	}
	@Test
	public void testProcess() throws InterruptedException, ExecutionException {
		String str="test";
		CompletableFuture<String> result=service.processTask(str);
		String res=result.get();
		assertEquals("process:"+str,res);
		
	}

}
