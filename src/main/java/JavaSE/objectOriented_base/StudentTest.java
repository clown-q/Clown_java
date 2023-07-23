package JavaSE.objectOriented_base;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.objectOriented
 * @Author: Clown
 * @CreateTime: 2023-07-23  09:25
 */
public class StudentTest extends PersonTest{
    public String bookname;

    public StudentTest(String name) {
        super(name);
    }

    @Override
    public void eatTest() {
        System.out.println("去学生餐厅吃饭");
    }
}
