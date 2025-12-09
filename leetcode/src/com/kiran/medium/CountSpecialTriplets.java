package com.kiran.medium;

import java.util.HashMap;
import java.util.Scanner;

public class CountSpecialTriplets {
	
	/*
	 * A special triplet is defined as a triplet of indices (i, j, k) such that:
	 * 
	 * --- 0 <= i < j < k < n, where n = nums.length
	 * --- nums[i] == nums[j] * 2
	 * --- nums[k] == nums[j] * 2
	 * 
	 * Return the total number of special triplets in the array.
	 * Since the answer may be large, return it modulo 109 + 7.
	 */
    public int specialTriplets(int[] nums) {

        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        int len = nums.length; 
        long ans = 0;

        for (int i = 1; i < len; i++) {
            right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
        }

        for (int j = 1; j < len - 1; j++) {

            left.put(nums[j - 1], left.getOrDefault(nums[j - 1], 0) + 1);

            right.put(nums[j], right.get(nums[j]) - 1);

            if (right.get(nums[j]) == 0) {
                right.remove(nums[j]);
            }

            int target = 2 * nums[j];

            if (left.containsKey(target) && right.containsKey(target)) {
                ans += (long) left.get(target) * right.get(target);
            }
        }

        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            while (true) {

                System.out.print("Enter array size: ");
                int size = input.nextInt();

                int[] nums = new int[size];

                System.out.println("Enter array elements: ");
                for (int i = 0; i < size; i++) {
                    nums[i] = input.nextInt();
                }

                CountSpecialTriplets obj = new CountSpecialTriplets();
                int result = obj.specialTriplets(nums);

                System.out.println("Special Triplets Count = " + result);

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
