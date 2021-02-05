public class SpeedTest {
        public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        int i = 0;
        while (i < 60000) {
            a.addFirst(i);
            i++;
        }


        i = 0;
        while (i < 65545) {
            a.removeFirst();
            i++;
        }
        a.printDeque();

        System.out.println("size is: "+a.items.length);
    }

}
