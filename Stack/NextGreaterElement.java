package Stack;

import java.util.*;

public class NextGreaterElement {

    // Brute Force Approach TC O(n^2)
    public static void findNextGreater1(int arr[], int nextGreater[]) {
        for (int i = 0; i < arr.length; i++) {
            nextGreater[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    nextGreater[i] = arr[j];
                    break;
                }
            }
        }
    }

    // Optimized Solution TC O(n), next greater from right side
    public static void findNextGreater2(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // Optimized Solution TC O(n), next greater from left side
    public static void findNextGreater3(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGreater1[] = new int[arr.length];
        int nextGreater2[] = new int[arr.length];
        int nextGreater3[] = new int[arr.length];

        findNextGreater1(arr, nextGreater1); // Brute force method O(n^2)
        findNextGreater2(arr, nextGreater2); // Optimized method, find next greater from right side
        findNextGreater3(arr, nextGreater3); // Optimized method, find next greater from left side

        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextGreater1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextGreater2[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextGreater3[i] + " ");
        }
    }
}
