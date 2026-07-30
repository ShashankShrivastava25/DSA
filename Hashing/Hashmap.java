import java.util.HashMap;
import java.util.Set;

public class Hashmap {
    public static void main(String args[]) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Indonesia", 50);
        hm.put("Bhutan", 75);

        System.out.println(hm);

        // Get O(1)
        System.out.println(hm.get("India"));
        System.out.println(hm.get("US")); // null

        // Contains Key O(1)
        System.out.println(hm.containsKey("India")); // true
        System.out.println(hm.containsKey("US")); // false

        // Remove O(1)
        System.out.println(hm.remove("Bhutan"));
        System.out.println(hm.remove("US")); // null

        System.out.println(hm);

        // Update O(1)
        hm.put("India", 200);

        System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // Is Empty
        System.out.println(hm.isEmpty());

        // Clear
        hm.clear();

        System.out.println(hm);
        System.out.println(hm.isEmpty());

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Indonesia", 50);
        hm.put("Bhutan", 75);

        // Iterate on Hashmap O(1)
        Set<String> keys = hm.keySet();

        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key=" + k + "," + "Value=" + hm.get(k));
        }
    }
}
