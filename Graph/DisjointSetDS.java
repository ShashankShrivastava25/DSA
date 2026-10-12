package Graph;

public class DisjointSetDS {
    static int n = 8;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }

        for (int i = 0; i < rank.length; i++) {
            rank[i] = 0;
        }
    }

    public static int find(int x) { // TC O(4k) -> O(1)
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) { // TC O(1)
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String args[]) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        System.out.println(find(5));
        union(1, 5);
        System.out.println(find(5));
    }
}
