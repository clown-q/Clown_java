package JavaSE.objectOriented_base;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.objectOriented
 * @Author: Clown
 * @CreateTime: 2023-07-23  10:54
 */
public class TeacherTest extends PersonTest{
    public TeacherTest(String name) {
        super(name);
    }
    @Override
    public void eatTest() {
        System.out.println("去教室餐厅吃饭");
    }
}
