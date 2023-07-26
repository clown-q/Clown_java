package JavaSE.DataStructure;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.DataStructure
 * @Author: Clown
 * @CreateTime: 2023-07-26  11:29
 */
public class DataTest {
    public static void main(String[] args) {
        SequenceTable<Integer> sequenceTable =new SequenceTable();
        for (int i = 0; i<15; i++) {
            sequenceTable.add(i, 0);
        }
        System.out.println(sequenceTable);
        sequenceTable.remove(4);
        System.out.println(sequenceTable);
        sequenceTable.getIndex(3);
    }
}
