package main.java.string.class_problems;

public class twosum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int target = 9;
        int target2 = 6;
        int[] result = twoSum(nums, target);
        int[] result2 = twoSum(nums2, target2);
        if (result != null) {
            System.out.println("Indices for first array: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found for first array.");
        }
        if (result2 != null) {
            System.out.println("Indices for second array: " + result2[0] + ", " + result2[1]);
        } else {
            System.out.println("No solution found for second array.");
        }
    }
}
