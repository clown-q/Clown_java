package JavaSE.DataStructure;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  17:25
 */
public class BinaryTree<T> {
    public T data;
    public BinaryTree<T> left,right;
    public BinaryTree(T data) {
        this.data = data;
    }
}
