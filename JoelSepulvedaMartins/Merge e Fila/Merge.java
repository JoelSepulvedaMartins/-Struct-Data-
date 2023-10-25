public class Merge {

    public static QueueLinkedList MergeQueue(QueueLinkedList queue1, QueueLinkedList queue2){
        QueueLinkedList mergedQueue = new QueueLinkedList();

        // Copiando todos os dados da primeira fila para o merge
        QueueLinkedList.Node temp = queue1.getHead();
        while(temp != null){ //
            mergedQueue.enqueue(temp.data);
            temp = temp.next;
        }
        mergedQueue.getTail().next = queue2.getHead();
        mergedQueue.setTail(queue2.tail);

        return mergedQueue;

    }

    public static int[] MergeArray(int[]arr1,int[]arr2){
        int size = arr1.length + arr2.length;
        int[] mergedArray = new int[size];
        for(int i=0;i<arr1.length;i++){
            mergedArray[i] = arr1[i];
        }
        int c=0;
        for(int j=arr1.length;j<size;j++){
            mergedArray[j] = arr2[c];
            c++;
        }
        return mergedArray;
    }


}
