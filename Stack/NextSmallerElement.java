package Stack;

import java.util.*;

public class NextSmallerElement {

    // Brute Force Approach TC O(n^2)
    public static void findNextSmaller1(int arr[], int nextSmaller[]) {
        for (int i = 0; i < arr.length; i++) {
            nextSmaller[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    nextSmaller[i] = arr[j];
                    break;
                }
            }
        }
    }

    // Optimized Solution TC O(n), next smaller from right side
    public static void findNextSmaller2(int arr[], int nextSmaller[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmaller[i] = -1;
            } else {
                nextSmaller[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // Optimized Solution TC O(n), next smaller from left side
    public static void findNextSmaller3(int arr[], int nextSmaller[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmaller[i] = -1;
            } else {
                nextSmaller[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextSmaller1[] = new int[arr.length];
        int nextSmaller2[] = new int[arr.length];
        int nextSmaller3[] = new int[arr.length];

        findNextSmaller1(arr, nextSmaller1); // Brute force method O(n^2)
        findNextSmaller2(arr, nextSmaller2); // Optimized method ,find next smaller from right side
        findNextSmaller3(arr, nextSmaller3); // Optimized method ,find next smaller from left side

        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextSmaller1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextSmaller2[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextSmaller3[i] + " ");
        }
    }
}
