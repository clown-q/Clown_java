package JavaSE.DataStructure;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-25  20:03
 */
public class SequenceTable<T>{
    int size = 0; //顺序表中当前数据数量
    int max = 10; //顺序表中能存放的最大数据个数
    Object[] objects = new Object[max]; //实际存放的地方

    public void add(T t,int index){//t是加入的数据，index是插入的位置
        if (size+1<=max||index>0||index>max){//判断插入一个数据后是否会溢出
            for(int i = size;i> index;i--){
                objects[i] = objects[i-1];
            }
            objects[index] = t;
            size++;
        }
    }
}
