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
    private LinkedNode last;
    private LinkedNode first;
    private int size;

    public LinkedListDeque() {
        sentinel = new LinkedNode(DEFAULT_ITEM, sentinel, sentinel);
        first = sentinel;
        last = sentinel;

        sentinel.prev = last;
        sentinel.next = first;

        first.prev = sentinel;
        last.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        LinkedNode oldFirst = sentinel.next;
        sentinel.next = new LinkedNode(item, oldFirst, sentinel);
        first = sentinel.next;

        first.prev = sentinel;
        first.next = oldFirst;
        oldFirst.prev = first;

        if (size == 0) {
            last = first;
        }
        size++;
    }

    public void addLast(T item) {
        LinkedNode oldLast = sentinel.prev;
        sentinel.prev = new LinkedNode(item, sentinel, oldLast);
        last = sentinel.prev;

        last.next = sentinel;
        last.prev = oldLast;
        oldLast.next = last;

        if (size == 0) {
            first = last;
        }
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    public void printDeque() {
        LinkedNode p = sentinel;
        String res = "";
        while (p.next != sentinel) {
            res += (p.next.item + " ");
            p = p.next;
        }
        System.out.println(res);
    }

    public T removeFirst() {
        size--;
        T f = first.item;
        first = first.next;
        sentinel.next = first;
        first.prev = sentinel;
        return f;
    }

    public T removeLast() {
        size--;
        T l = last.item;
        last = last.prev;
        last.next = sentinel;
        sentinel.prev = last;
        return l;
    }

    /*Iteration*/
    public T get(int index) {
        if (size - 1 < index || index < 0) {
            return null;
        }
        LinkedNode p = sentinel.next;
        int i = 0;
        while (i != index) {
            i++;
            p = p.next;
        }
        return p.item;
    }

    private T getRecursion(int number, LinkedNode p) {
        if (number == 0) {
            return p.item;
        }
        return getRecursion(number - 1, p.next);
    }

    public T getRecursive(int index) {
        LinkedNode pointer = sentinel.next;
        if (index == 0) {
            return pointer.item;
        }
        return getRecursion(index - 1, pointer.next);
    }
}
