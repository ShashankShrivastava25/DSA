import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem { // TC O(mlogm + nlogn), SC O(m+n)
    public static void main(String args[]) {
        // int m = 6; -> no. of columns
        // int n = 4; -> no. of rows
        int cost = 0; // final cost

        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        int h = 0; // pointer which will traverse in horizontal costs
        int v = 0; // pointer which will traverse in vertical costs

        int vp = 1; // no. of vertical peices
        int hp = 1; // no. of horizontal peices

        Arrays.sort(costVer, Collections.reverseOrder()); // TC O(mlogm), SC O(m)
        Arrays.sort(costHor, Collections.reverseOrder()); // TC O(nlogn), SC O(n)

        while (h < costHor.length && v < costVer.length) { // O(m+n)
            if (costVer[v] <= costHor[h]) { // horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costHor.length) { // O(n)
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while (v < costVer.length) { // O(m)
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.print("Min cost = " + cost);

    }
}
