public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private final int Factor = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        size += 1;
        if (size == items.length) {
            increaseSize();
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
    }

    public void addLast(T item) {
        if (size == items.length) {
            increaseSize();
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return Math.max(size, 0);
    }

    public void printDeque() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res.append(items[i]).append(" ");
        }
        if (res.length() > 0) {
            System.out.println(res.substring(0, res.length() - 1));
        }
    }

    public T removeFirst() {
        if (size - 1 < 0) {
            return null;
        }

        T first = items[0];
        System.arraycopy(items, 1, items, 0, size - 1);
        items[size - 1] = null;
        size--;
        if (size >=16 & getUsageRatio() < 0.25) {
            shrinkSize();
        }
        return first;
    }

    public T removeLast() {
        if (size - 1 < 0) {
            return null;
        }
        T last = get(size - 1);
        size--;
        items[size] = null;

        if (size >=16 & getUsageRatio() < 0.25) {
            shrinkSize();
        }
        return last;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return items[index];
    }

    private double getUsageRatio() {
        double occupy = (double) size;
        double capacity = items.length;
        return occupy / capacity;
    }

    private void increaseSize() {
        resizing((items.length) * 2);
//        System.out.println("increase size as " + items.length);
    }

    private void shrinkSize() {
        resizing((items.length) / 2);
//        System.out.println("decrease size as " + items.length);
    }

    private void resizing(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(items, 0, copy, 0, size);
        items = copy;
    }


//    public static void main(String[] args) {
//        ArrayDeque<Integer> a = new ArrayDeque<>();
//        int i=0;
//        while (i<1000){
//            a.addFirst(i);
//            i++;
//        }
//        i=0;
//        while (i<999){
//            a.removeFirst();
//            i++;
//        }
////        System.out.println("size is: "+a.items.length);
//    }


}
