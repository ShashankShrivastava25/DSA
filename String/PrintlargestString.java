package String;

public class PrintlargestString {
    public static void largeststring(String str[]) {
        String Largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (Largest.compareTo(str[i]) < 0) {
                Largest = str[i];
            }
        }
        System.out.print("Largest String is : " + Largest);
    }

    public static void main(String args[]) {
        String str[] = { "Banana", "Apple", "Mango" };
        largeststring(str);
    }
}
