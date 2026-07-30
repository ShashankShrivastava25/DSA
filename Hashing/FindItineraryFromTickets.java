import java.util.HashMap;

public class FindItineraryFromTickets { // TC O(n)

    public static String getStartPoint(HashMap<String, String> hm) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : hm.keySet()) {
            revMap.put(hm.get(key), key);
        }

        for (String key : hm.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }

    public static void main(String args[]) {
        String arr[][] = { { "Chennai", "Bengaluru" },
                { "Mumbai", "Delhi" },
                { "Goa", "Chennai" },
                { "Delhi", "Goa" } };

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i][0], arr[i][1]);
        }

        String start = getStartPoint(hm);
        System.out.print(start);

        for (int i = 0; i < hm.size(); i++) {
            System.out.print(" -> " + hm.get(start));
            start = hm.get(start);
        }
    }
}
