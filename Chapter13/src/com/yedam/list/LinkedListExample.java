package com.yedam.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		//ArrayList
		for(int i =0; i<10000; i++) {
			list1.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println("ArrayList 걸린 시간 : " + 
		(endTime - startTime) + "ns");
	}
}
