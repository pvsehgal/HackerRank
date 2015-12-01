package com.sehgal;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TwoStrings {

	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int noOfTests = sc.nextInt();
		
		while (noOfTests-- > 0) {
			char[] char1arr = sc.next().toCharArray();
			char[] char2arr = sc.next().toCharArray();
			
			//System.out.println(binarySearch(char1arr, char2arr[0]));
			
			if (char1arr.length <= 100000 && char2arr.length <= 100000) {
				boolean contains = false;    
				Arrays.sort(char1arr);
				Arrays.sort(char2arr);
				
				if(char1arr.length > char2arr.length){
					outerforloop:
					for (int i = 0; i < char2arr.length; i++) {
						//if (Arrays.binarySearch(char1arr, char2arr[i]) >= 0){
						if(binarySearch(char1arr, char2arr[i])){
							contains = true;
							break outerforloop;
						}
					}
				} else {
					outerforloop2:
					for (int i = 0; i < char1arr.length; i++) {
						//System.out.println("i: " + i);
						//if (Arrays.binarySearch(char2arr, char1arr[i]) >= 0){
						if(binarySearch(char2arr, char1arr[i])){
							contains = true;
							break outerforloop2;
						}
					}
				}
				if(contains) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			
		}
		sc.close();
	}
	
	static boolean binarySearch(char[] array, char target) {
		int upper = array.length-1;
		int lo = 0;
		int middle = (upper + lo) /2;
		
		while (lo <= upper){
			if(array[middle] == target){
				return true;
			} else if(target > array[middle]){
				lo = middle+1;
			} else {
				upper = middle-1;
			}
			middle = (lo+upper)/2;
			
	   }
		
	return false;
	}
	
	
}
