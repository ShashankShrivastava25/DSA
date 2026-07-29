public class ArrayAsArgument {
    public static void updateArray(int marks[], int unChangeAble) {
        unChangeAble = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 2;
        }
    }

    public static void main(String args[]) {
        int marks[] = { 91, 92, 93 };
        int unChangeAble = 5;
        updateArray(marks, unChangeAble);
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]); // value of array will change
        }
        System.out.println(unChangeAble); // value of variable will not change
    }
}
