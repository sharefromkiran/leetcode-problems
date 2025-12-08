package com.kiran.easy;

import java.util.Scanner;

public class PythagorasTripleCounter {
	
	/**
	 * Counts the number of Pythagorean triples (a, b, c) 
     * such that a^2 + b^2 = c^2 and all are ≤ limit.
     * 
	 * @param num
	 * @return
	 */
	public int countTriples(int num) {
	       int count = 0;

	       for (int a = 1; a <= num; a++) {
	        for (int b = a; b <= num; b++) {
	            int square = a*a + b*b;
	            int c = (int) Math.sqrt(square);

	            if (c*c == square && c <= num) {
	                count ++;
	            }
	        }
	       }

	       return (count * 2);
	}
	

	public static void main(String[] args) {
		int num;
		
		// Input Section (userInput from Keyboard)
		try (Scanner input = new Scanner(System.in)) {
			
			System.out.print("Enter number: ");
			num = input.nextInt();
		}
		
		// Business Logic
		PythagorasTripleCounter ptt = new PythagorasTripleCounter();
		int result = ptt.countTriples(num);
		
		System.out.println(result);

	}

}
