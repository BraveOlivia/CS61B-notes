import java.util.Arrays;

public class Sort {
    /**
     * Sorts strings destructively.
     */
    public static void sort(String[] x) {
        // find the smallest item
        // move it to the front
        // selection sort the rest (using recursion?)


        int smallestIndex = findSmallest(x);
        swap(x, 0, smallestIndex);
        String[] rest = getRest(x);
        while (rest.length!=1){
            sort(rest);
            rest = getRest(x);
        }
//        sort(Arrays.copyOfRange(x, 1, x.length - 1));
    }

    public static String[] getRest(String[] x){
        x = Arrays.copyOfRange(x, 1, x.length);
//        for (int i=0;i< copy.length;i++){
//            System.out.println(copy[i]);
//        }
        return x;
    }

    public static int findSmallest(String[] x) {
        int smallestIndex = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static void main(String[] args) {
        String[] x = new String[]{"i", "am", "an", "very", "pretty", "olivia"};
        // x = Arrays.copyOfRange(x, 1, x.length);
        sort(x);
//        sortRecursion(x);
        // for (int i=0;i<x.length;i++){
        //     System.out.println(x[i]);
        // }
    }
}
