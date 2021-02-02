public class LinkedListDeque<T> {

    public class LinkedNode {
        public T item;
        private LinkedNode next;
        private LinkedNode prev;

        private LinkedNode(T first, LinkedNode next, LinkedNode prev) {
            this.item = first;
            this.next = next;
            this.prev = prev;
        }
    }

    private T DEFAULT_ITEM;
    public LinkedNode sentinel;
    public LinkedNode last;
    public LinkedNode first;
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

//        System.out.println("first item -> " + first.item);
        size++;
    }

    public void addLast(T item) {
        LinkedNode oldLast = sentinel.prev;
        sentinel.prev = new LinkedNode(item, sentinel, oldLast);
        last = sentinel.prev;

        last.next = sentinel;
        last.prev = oldLast;
        oldLast.next = last;
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
        String nextString = "";
        String preString ="";
        while (p.next != sentinel) {
            nextString += (p.next.item + " ");
            p = p.next;
        }
//        p = sentinel;
//        while (p.prev != null) {
//            preString += (p.prev.item + " ");
//            p = p.prev;
//        }
//        preString = preString.substring(0,preString.length()-1);
//        while(preString.length()!=0){
//            if (preString.substring(preString.length()-1)!=" "){
//                nextString += preString.substring(preString.length()-1);
//            }
//            preString = preString.substring(0,preString.length()-1);
//        }
        System.out.println(nextString);
    }

    public T removeFirst() {
        size--;
        T f = first.item;
        first = first.next;
        sentinel.next = first;
        return f;
    }

    public T removeLast() {
        size--;
        T l = last.item;
        last = last.prev;
        sentinel.prev = last;
        return l;
    }

    /*Iteration*/
    public T get(int index) {
        if(size -1 < index){
            return null;
        }
        return null;
    }

    public T getRecursive(int index) {
        return null;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque();
        l.addLast(8);
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);
        l.addLast(5);
        l.addLast(7);
        l.printDeque();
        System.out.println("1.The size of the list -> " + l.size());
        System.out.println("remove first item -> "+l.removeFirst());
        System.out.println("remove last item -> "+l.removeLast());
        l.printDeque();
//        System.out.println("______________________");
//        System.out.println(l.sentinel.item);//null
//        System.out.println(l.first.item); //3
//        System.out.println(l.first.prev.item);//null
//        System.out.println(l.first.prev.prev.item); //7
//        System.out.println(l.first.prev.prev.prev.item);//5
//        System.out.println(l.first.prev.prev.prev.prev.item);//1
//        System.out.println(l.first.prev.prev.prev.prev.prev.item);//3

    }
}
