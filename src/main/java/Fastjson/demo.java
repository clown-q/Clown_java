package Fastjson;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson
 * @Author: Clown
 * @CreateTime: 2023-10-10  14:42
 */
public class demo {
    private String cmd;

    public void setCmd(String cmd) throws IOException {
        this.cmd = cmd;
        Runtime.getRuntime().exec(this.cmd);
    }
}
