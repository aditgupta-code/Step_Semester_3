package main.java.string.class_problems;

public class rotatearray {
    static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than n
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        return arr;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] arr2 = {1, 2};
        int k2 = 3;
        int[] rotatedArray = rotateArray(arr, k);
        int[] rotatedArray2 = rotateArray(arr2, k2);
        System.out.print("Rotated array: ");
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Rotated array 2: ");
        for (int num : rotatedArray2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
