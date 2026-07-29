package String;

import java.util.Scanner;

public class FindShortestDistance {
    public static void findshortestdistance(String str) {
        int y1 = 0;
        int x1 = 0;
        int y2 = 0;
        int x2 = 0;

        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);
            if (dir == 'N') {
                y2++;
            } else if (dir == 'S') {
                y2--;
            } else if (dir == 'E') {
                x2++;
            } else {
                x2--;
            }
        }
        int x3 = x2 - x1;
        int x4 = x3 * x3;
        int y3 = y2 - y1;
        int y4 = y3 * y3;
        double SD = Math.sqrt(x4 + y4);
        System.out.println("Shortest Distance is : " + SD);
    }

    public static void main(String args[]) {
        System.out.print("Enter a String having N,S,E,W: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        findshortestdistance(str);
        sc.close();
    }
}
