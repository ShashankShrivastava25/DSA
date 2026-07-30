import java.util.TreeMap;
import java.util.Set;

public class Treemap {
    public static void main(String args[]) {
        // Create
        TreeMap<String, Integer> tm = new TreeMap<>();

        // Insert O(logn)
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("Indonesia", 50);
        tm.put("Bhutan", 75);

        System.out.println(tm);

        // Get O(logn)
        System.out.println(tm.get("India"));
        System.out.println(tm.get("US")); // null

        // Contains Key O(1)
        System.out.println(tm.containsKey("India")); // true
        System.out.println(tm.containsKey("US")); // false

        // Remove O(logn)
        System.out.println(tm.remove("Bhutan"));
        System.out.println(tm.remove("US")); // null

        System.out.println(tm);

        // Update O(logn)
        tm.put("India", 200);

        System.out.println(tm);

        // Size
        System.out.println(tm.size());

        // Is Empty
        System.out.println(tm.isEmpty());

        // Clear
        tm.clear();

        System.out.println(tm);
        System.out.println(tm.isEmpty());

        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("Indonesia", 50);
        tm.put("Bhutan", 75);

        // Iterate on Treemap O(1)
        Set<String> keys = tm.keySet();

        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key=" + k + "," + "Value=" + tm.get(k));
        }
    }
}
