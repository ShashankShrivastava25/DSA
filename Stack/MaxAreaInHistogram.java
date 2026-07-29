package Stack;

import java.util.*;

public class MaxAreaInHistogram {
    public static int maxArea(int arr[]) { // TC O(n+n+n) = O(3n) = O(n)
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int nextSmallerLeft[] = new int[arr.length];
        int nextSmallerRight[] = new int[arr.length];

        // Next Smaller Left O(n)
        for (int i = 0; i <= arr.length - 1; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();

        // Next Smaller Right O(n)
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerRight[i] = arr.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < arr.length; i++) { // O(n)
            int height = arr[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String args[]) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.print("Max Area is : " + maxArea(heights));
    }
}
