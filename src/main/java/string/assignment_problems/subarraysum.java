package main.java.string.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class subarraysum {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // empty prefix has sum 0, occurs once

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) has been seen before, those prefixes mark
            // the start of a subarray ending here that sums to k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
    public static void main(String[]args){
        
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k)); // Output: 2

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(subarraySum(nums2, k2)); // Output: 2
    }
}
