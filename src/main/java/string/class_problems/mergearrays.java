package main.java.string.class_problems;

public class mergearrays {
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }
    public static void main(String[] args){
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] arr3 = {};
        int[] arr4 = {1,2,3};
        int[] mergedArray = mergeSortedArrays(arr1, arr2);
        int[] mergedArray2 = mergeSortedArrays(arr3, arr4);
        System.out.print("Merged array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Merged array 2: ");
        for (int num : mergedArray2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
