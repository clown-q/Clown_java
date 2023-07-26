package JavaSE.DataStructure;

import java.util.NoSuchElementException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  16:26
 */
public class Queue_Listed<T> {
    private class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    private Node<T> nodeHead = new Node<>(null);//头结点,指向队首
    private int size = 0;

    @Override
    public String toString() {
        return "Queue_Listed{" +
                "nodeHead=" + nodeHead +
                ", size=" + size +
                '}';
    }

    public void add(T t){
        Node<T> head = nodeHead;
        for (int i=0;i<size;i++){ //找到尾结点
            head = head.next;
        }
        Node<T> node = new Node<>(t); //创建新结点
        head.next = node;
        size++;
    }

    public T remove(){
        T t = nodeHead.next.data;
        if (nodeHead.next==null){
            throw  new NoSuchElementException("队列为空");
        }
        nodeHead.next = nodeHead.next.next;
        size--;
        return t;
    }
}
