package JavaSE.DataStructure;

import java.util.NoSuchElementException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  15:40
 */
public class Stack_Linked<T> {
    class Node<T>{
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
    private Node<T> nodeHead = new Node<>(null);
    private int size = 0;

    public void push(T t){
        Node<T> node = new Node<>(t);//创建一个新结点
        node.next = nodeHead.next; //新结点指向头结点指向的结点
        nodeHead.next=node; //头结点指向新结点
        size++;
    }

    public T pop(){
        if (nodeHead.next==null){ //判断栈空
            throw new NoSuchElementException("栈是空的");
        }
        T t = nodeHead.next.data; //保存数据
        nodeHead.next = nodeHead.next.next; //头结点指向下一个结点的下一个结点
        size--;
        return t;
    }

    @Override
    public String toString() {
        return "Stack_Linked{" +
                "nodeHead=" + nodeHead +
                ", size=" + size +
                '}';
    }
}
