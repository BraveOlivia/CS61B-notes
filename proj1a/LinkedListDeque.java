public class LinkedListDeque<T> {

    private class LinkedNode {
        private T item;
        private LinkedNode next;
        private LinkedNode prev;

        private LinkedNode(T first, LinkedNode next, LinkedNode prev) {
            this.item = first;
            this.next = next;
            this.prev = prev;
        }
    }

    private T DEFAULT_ITEM;
    private LinkedNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new LinkedNode(DEFAULT_ITEM, null, null);
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new LinkedNode(item, sentinel.next, sentinel.prev);
        size++;
    }

    public void addLast(T item) {
        sentinel.prev = new LinkedNode(item, sentinel.prev, sentinel.next);
        size++;
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
        LinkedNode p = sentinel;
        String res = "";
        while (p.next != null) {
            res += (p.next.item + " ");
            p = p.next;
        }
        p = sentinel;
        while (p.prev != null) {
//            System.out.println(p.prev.item);
            res += (p.prev.item + " ");
            p = p.prev;
        }
        System.out.println(res);
    }

    public T removeFirst() {
        size--;
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        return first;
    }

    public T removeLast() {
        size--;
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        return last;
    }

    /*Iteration*/
    public T get(int index) {
        return null;
    }

    public T getRecursive(int index) {
        return null;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque();
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);
        l.addLast(5);
        l.addLast(7);
        l.printDeque();
        System.out.println("1.The size of the list -> " + l.size());
//        System.out.println(l.isEmpty());
        System.out.println(l.removeFirst());
        System.out.println(l.removeLast());
        l.printDeque();
        System.out.println("2.The size of the list -> " + l.size());
    }
}
