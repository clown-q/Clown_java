package JavaSE.DataStructure;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  11:29
 */
public class DataTest {
//    public static void main(String[] args) {//顺序表
//        SequenceTable<Integer> sequenceTable =new SequenceTable();
//        for (int i = 0; i<15; i++) {
//            sequenceTable.add(i, 0);
//        }
//        System.out.println(sequenceTable);
//        sequenceTable.remove(4);
//        System.out.println(sequenceTable);
//        sequenceTable.getIndex(3);
//    }

//    public static void main(String[] args) {//链表
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i<5; i++) {
//            linkedList.add(i, 0);
//        }
//        System.out.println(linkedList);
//        linkedList.remove(1);
//        System.out.println(linkedList);
//        linkedList.getIndex(3);
//    }

//    public static void main(String[] args) {//栈
//        Stack_Linked<Integer> stackLinked = new Stack_Linked<>();
//        stackLinked.push(10);
//        stackLinked.push(10);
//        stackLinked.push(10);
//        System.out.println(stackLinked);
//        System.out.println(stackLinked.pop());
//        System.out.println(stackLinked);
//    }
    public static void main(String[] args) {
        Queue_Listed<Integer> queueListed =new Queue_Listed<>();
        queueListed.add(10);
        queueListed.add(10);
        queueListed.add(10);
        System.out.println(queueListed);
        System.out.println(queueListed.remove());
        System.out.println(queueListed);
    }
}
