package com.te.learnjava8.basic;

public class MaxMinArray {
	public static void main(String[] args) {
		
		int a[] = {2,12,-2,11,23};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		  for (int i = 0;i < a.length;i++) {
				  if(a[max] > a[min]) {
					  if(a[i]>max);
					  max = a[i];
				  if(a[i] < a[min])
					  min = a[i];
				  }
				  System.out.println("max "+max);
				  System.out.println("min "+min);
			    
	  }
	}	  
  }



