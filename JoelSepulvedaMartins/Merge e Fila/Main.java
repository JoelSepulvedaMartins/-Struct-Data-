public class Main {
    public static void main(String[] args) {


        QueueLinkedList queue1 = new QueueLinkedList();

        queue1.enqueue(5);
        queue1.enqueue(3);
        queue1.enqueue(2);


        queue1.BubbleSort();

        queue1.show();


    }
}
