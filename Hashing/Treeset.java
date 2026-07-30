import java.util.TreeSet;

public class Treeset {
    public static void main(String args[]) {
        // Create
        TreeSet<Integer> ts = new TreeSet<>();

        // Insert O(logn)
        ts.add(2);
        ts.add(4);
        ts.add(6);
        ts.add(3);
        ts.add(2);
        ts.add(5);

        System.out.println(ts);

        // Remove O(logn)
        ts.remove(5);

        System.out.println(ts);

        // Contains O(1)
        System.out.println(ts.contains(2));
        System.out.println(ts.contains(5));

        // Size
        System.out.println(ts.size());

        // isEmpty
        System.out.println(ts.isEmpty());

        // Clear
        ts.clear();
        System.out.println(ts.size());
        System.out.println(ts.isEmpty());
    }
}
