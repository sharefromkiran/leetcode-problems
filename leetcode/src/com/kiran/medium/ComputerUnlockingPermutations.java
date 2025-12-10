package com.kiran.medium;

import java.util.Scanner;

public class ComputerUnlockingPermutations {
	static final int mod = 1_000_000_007;
	
	public int countPermutations(int[] complexity) {
		
		int len = complexity.length;
		
		for (int i = 1; i < len; i++) {
			if (complexity[i] <= complexity[0]) return 0;
		}
		
		long fact = 1;
		for (int i = 2; i < len; i++) {
			fact = (fact * i) % mod;
		}
		
		return (int) fact;
	}
	
	
	public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            while (true) {

                System.out.print("Enter array size: ");
                int size = input.nextInt();

                int[] complexity = new int[size];

                System.out.println("Enter array elements: ");
                for (int i = 0; i < size; i++) {
                	complexity[i] = input.nextInt();
                }

                ComputerUnlockingPermutations obj = new ComputerUnlockingPermutations();
                int answer = obj.countPermutations(complexity);

                System.out.println("Permutations Count = " + answer);

                // Ask user if they want to test again
                System.out.print("\nDo you want to test another array? (yes/no): ");
                String choice = input.next().toLowerCase();

                if (!choice.equals("yes")) {
                    System.out.println("Exiting... Thank you!");
                    break;
                }

                System.out.println();
            }
        }
	}
}
