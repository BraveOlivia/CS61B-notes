public class Sort {
    /**
     * Sorts strings destructively.
     */
    public static void sort(String[] x) {
        // find the smallest item
        // move it to the front
        // selection sort the rest (using recursion?)

        sort(x, 0);
    }

    public static void sort(String[] x, int startingIndex) {
        int smallestIndex = findSmallest(x);
        swap(x, startingIndex, smallestIndex);
        while (startingIndex < x.length-1) {
            sort(x, startingIndex + 1);
        }
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
        sort(x);
    }
}
