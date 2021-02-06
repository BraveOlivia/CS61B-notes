public class SLList<BleepBlorp> {

	// No ability to access method outside the static class
	public class IntNode {
        public BleepBlorp item;
        public IntNode next;
        public IntNode(BleepBlorp i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private BleepBlorp t;
    private IntNode sentinel;
    private IntNode last;
    private IntNode first;
    private int size;

    public SLList(){
    	sentinel = new IntNode(t,null);
    	last = sentinel;
        first = sentinel;
    	size = 0;
    }

    // public SLList(BleepBlorp x) {
    // 	sentinel = new IntNode(x,null);
    //     sentinel.next = new IntNode(x,null);
    //     last = sentinel.next;
    //     size = 1;
    // }

    /** Adds an item to the front of the list. */
    public void addFirst(BleepBlorp x) {
    	size+=1;
        sentinel.next = new IntNode(x, sentinel.next);
        first = sentinel.next;
    }    

    /** Retrieves the front item from the list. */
    public BleepBlorp getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast_old(BleepBlorp x) {
    	size +=1;
    	IntNode p = sentinel;
    	while(p.next != null){
    		p = p.next;
    	}
    	p.next = new IntNode(x,null);
    }

    public void addLast(BleepBlorp x) {
    	size++;
    	last.next = new IntNode(x,null);
    	last = last.next;
    }

    public BleepBlorp getLast(){
    	return last.item;
    }


    /** Returns the number of items in the list using recursion. */
    public int iterativeSize() {
       if(sentinel.next == null){
       	return 1;
       }
       int num = 1;
       while(sentinel.next != null){
       		sentinel = sentinel.next;
       		num ++;
       }
       return num;
    }

    public int size() {
    	return size(this);
    }


    private int size(IntNode p){
    	if(p.next == null){
    		return 1;
    	}
    	return 1 + size(p.next);
    }


    public static void main(String[] args) {
    	SLList<Integer> n=new SLList<>();
    	n.addFirst(5);
        n.addFirst(7);
    	n.addLast(1);
    	n.addLast(2);
    	System.out.println("first number-> "+n.getFirst());
    	System.out.println(n.size());
    	System.out.println("last number -> "+n.getLast());

    	// SLList<String> m=new SLList<>();
    	// m.addLast("Olivia");

    	// System.out.println(m.getLast());
    }

}