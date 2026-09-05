package main.java.string.assignment_problems;

public class arrayproduct {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        int[] result2 = productExceptSelf(nums2);
        System.out.print("Product array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Product array 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
