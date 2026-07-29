import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class IndianCoins { // TC O(nlogn)
    public static void main(String args[]) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder()); // O(nlogn)

        int count = 0;
        System.out.print("Enter the amount : ");
        Scanner sc = new Scanner(System.in);
        int amt = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) { // O(n)
            if (coins[i] <= amt) {
                while (coins[i] <= amt) {
                    amt -= coins[i];
                    count++;
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("Total min coins used = " + count);
        for (int i = 0; i < ans.size(); i++) { // O(n)
            System.out.print(ans.get(i) + " ");
        }
        sc.close();
    }
}
