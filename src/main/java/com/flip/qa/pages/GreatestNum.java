package com.flip.qa.pages;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;

public class GreatestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	//findGreatest(12,5,8);
		findGreatestArray();
	}
	
	public static void findGreatest(int a, int b, int c){
		
		if(a>b){
			if(a>c){
			System.out.println("a is greatest");
			}
		}else if(b>c){
				System.out.println("b is greatest");
				}else
			System.out.println("c is greatest");
		
	}
	
	public static void findGreatestArray(){
		
		Integer[] abc = {2,4,6,39,78,34,9,89,34};
		int maxValue = Collections.max(Arrays.asList(abc));
		
		System.out.println(maxValue);





		
	}

}
