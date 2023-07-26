package JavaSE.DataStructure;

import java.util.Arrays;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  11:02
 */
public class SequenceTable<T> {
    int size = 0;   //顺序表中当前元素数量
    int max = 10;   //顺序表能存放的最大元素数量
    Object[] arr = new Object[max];     //实际存放元素的数组
//    public void add(T t,int index){ //T是要插入的数据，index是要插入的位置
//        if(index<0||index>size){
//            throw new IndexOutOfBoundsException("插入位置不合法,插入的位置只能是0 - "+size);
//        }else if(size+1>max){
//            throw new IndexOutOfBoundsException("最多只能存放"+max+"个数据，请尝试删除数据后再插入");
//        }else {
//            for (int i =size;i>index;i--){
//                arr[i] = arr[i-1];
//            }
//            arr[index]=t;
//            size++;
//        }
//    }



    //扩容的写法
    public void add(T t,int index){ //T是要插入的数据，index是要插入的位置
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("插入位置不合法,插入的位置只能是0 - "+size);
        }else if(size+1>max){
            max = max + (max >> 1);
            Object[] arr2 = new Object[max];
            System.arraycopy(arr,0,arr2,0,size);
            arr = arr2;
        }else {
            for (int i =size;i>index;i--){
                arr[i] = arr[i-1];
            }
            arr[index]=t;
            size++;
        }
    }


    public void remove(int index){//返回删除的元素
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("删除的索引不合法,范围应该为0 - "+(size-1));
        }else {
            for(int i=index;i<size;i++){
                arr[i]=arr[i+1];
            }
            size--;
        }
    }
    public void getIndex(int index){
        if(index<0||index>size-1){
            throw  new IndexOutOfBoundsException("索引不合法,范围应该为0 - "+(size-1));
        }else {
            System.out.println(arr[index]);
        }
    }
    @Override
    public String toString() {
        return "SequenceTable{" +
                "size=" + size +
                ", max=" + max +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
