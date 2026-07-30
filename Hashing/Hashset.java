import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String args[]) {
        // Create
        HashSet<Integer> hs = new HashSet<>();

        // Insert O(1)
        hs.add(2);
        hs.add(4);
        hs.add(6);
        hs.add(3);
        hs.add(2);
        hs.add(5);

        System.out.println(hs);

        // Remove O(1)
        hs.remove(5);

        System.out.println(hs);

        // Iteration on Sets

        // 1. Using Iterator Interface O(n)
        Iterator<Integer> itr = hs.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 2. Using Enhanced for Loop O(n)
        for (Integer key : hs) {
            System.out.print(key + " ");
        }
        System.out.println();

        // Contains O(1)
        System.out.println(hs.contains(2));
        System.out.println(hs.contains(5));

        // Size
        System.out.println(hs.size());

        // isEmpty
        System.out.println(hs.isEmpty());

        // Clear
        hs.clear();
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
    }
}
