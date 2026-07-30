import java.util.LinkedList;
import java.util.ArrayList;

public class ImplementHashMap {

    public static class HashMap<K, V> {
        // K,V -> generic => type of key and value are not fixed yet so we make it
        // generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        // n -> total no. of nodes
        // N -> size of buckets array
        // N = buckets.length
        private LinkedList<Node> buckets[]; // Array of LinkedList

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            N = N * 2;
            @SuppressWarnings("unchecked")
            LinkedList<Node> newBuckets[] = new LinkedList[N];
            buckets = newBuckets;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // O(lambda) -> O(1)
            int bi = hashFunction(key); // bi -> bucket index (0 to size-1)
            int di = searchInLL(key, bi); // di -> data index
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) { // threshold value = 2.0 (2.0 is taken as an example)
                rehash();
            }
        }

        public V remove(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public boolean containsKey(K key) { // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public ArrayList<K> keySet() { // O(1)
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() { // O(1)
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Indonesia", 80);
        hm.put("US", 75);
        ArrayList<String> keys = hm.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i) + ", ");
        }
        System.out.println();
        System.out.println(hm.isEmpty());
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.get("Indonesia"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
