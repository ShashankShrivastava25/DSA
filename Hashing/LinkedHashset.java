import java.util.LinkedHashSet;

public class LinkedHashset {
    public static void main(String args[]) {
        // Create
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        // Insert O(1)
        lhs.add(2);
        lhs.add(4);
        lhs.add(6);
        lhs.add(3);
        lhs.add(2);
        lhs.add(5);

        System.out.println(lhs);

        // Remove O(1)
        lhs.remove(5);

        System.out.println(lhs);

        // Contains O(1)
        System.out.println(lhs.contains(2));
        System.out.println(lhs.contains(5));

        // Size
        System.out.println(lhs.size());

        // isEmpty
        System.out.println(lhs.isEmpty());

        // Clear
        lhs.clear();
        System.out.println(lhs.size());
        System.out.println(lhs.isEmpty());
    }
}
