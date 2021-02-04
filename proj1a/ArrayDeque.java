public class ArrayDeque<T> {

    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        size += 1;
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
    }

    public void addLast(T item) {
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += (items[i] + " ");
        }
        System.out.println(res.substring(0, res.length() - 1));
    }

    public T removeFirst() {
        T first = items[0];
        for (int i = 1; i < size; i++) {
            items[i - i] = items[i];
        }
        items[size - 1] = null;
        return first;
    }

    public T removeLast() {
        T last = items[size - 1];
        size--;
        items[size - 1] = null;
        return last;
    }

    public T get(int index) {
        return items[index];
    }

    private void handleSize(){
        if(size < 16){
            resizing(16);
        } else {

        }
    }

    private void resizing(int capacity){
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(items,0,copy,0,size());
        items = copy;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(9);
        a.addLast(5);
        a.addFirst(2);
        a.addLast(3);
        a.addFirst(1);
        a.printDeque();
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));
        System.out.println(a.get(3));
    }


}
