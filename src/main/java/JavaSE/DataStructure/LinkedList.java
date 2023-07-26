package JavaSE.DataStructure;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  13:01
 */
public class LinkedList<T> {
    class Node<T>{//结点
        private T data; //结点存放的数据
        private Node<T> next; //指向下一个结点

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
    private Node<T> headNode = new Node<>(null);//头结点设置为空
    private int size=0;

    public void add(T t,int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("插入位置不合法,插入的位置只能是0 - "+size);
        }else {
            Node<T> head = headNode; //使用头结点
            for (int i = 0;i<index;i++){
                head = head.next; //遍历到要插入的位置
            }
            Node<T> node = new Node<>(t); //创建一个新的结点
            node.next = head.next; //新结点指向当前结点指向的结点
            head.next = node; //前一个结点指向当前结点
            size++;
        }
    }

    public void remove(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("删除的索引不合法,范围应该为0 - "+(size-1));
        }else {
            Node<T> head = headNode;
            for(int i=0;i<index;i++){
                head=head.next;
            }
            head.next=head.next.next;
            size--;
        }
    }

    public void getIndex(int index){
        Node<T> head = headNode;
        for(int i=0;i<index;i++){
            head = head.next;
        }
        System.out.println(head.data);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "headNode=" + headNode +
                ", size=" + size +
                '}';
    }
}
