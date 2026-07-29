package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class InbuiltSort {
    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 2, 4, 6, 8, 7 };
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");

        int arr1[] = { 1, 3, 5, 2, 4, 6, 8, 7 };
        Arrays.sort(arr1, 2, 5);// ending index is excluded
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println("");

        Integer arr2[] = { 1, 3, 5, 2, 4, 6, 8, 7 };
        Arrays.sort(arr2, Collections.reverseOrder());
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);
        }
        System.out.println("");

        Integer arr3[] = { 1, 3, 5, 2, 4, 6, 8, 7 };
        Arrays.sort(arr3, 2, 5, Collections.reverseOrder());
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
        }
        System.out.println("");
    }
}
