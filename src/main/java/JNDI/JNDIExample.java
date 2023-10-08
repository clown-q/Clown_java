package JNDI;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI
 * @Author: Clown
 * @CreateTime: 2023-09-23  09:59
 */
public class JNDIExample {
    public static void main(String[] args) throws NamingException {
        //初始化上下文，获取一个初始的环境变量
        InitialContext context = new InitialContext();
        //获取指定对象
        context.lookup("JNDIName");
    }
}
