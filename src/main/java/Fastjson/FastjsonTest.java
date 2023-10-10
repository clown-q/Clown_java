package Fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson
 * @Author: Clown
 * @CreateTime: 2023-10-08  11:24
 */
public class FastjsonTest {
    public static void main(String[] args) {
//        String str = "{\"name\":\"aaa\",\"age\":18}";
//        Test test = JSON.parseObject(str, Test.class);
//        System.out.println(test.toString());
//        Test test = new Test();
//        String str = JSON.toJSONString(test);
//        System.out.println(str);
//        String str = "{\"@type\":\"Fastjson.Test\",\"age\":18,\"name\":\"aaa\"}";
        String str = "{\"@type\":\"Fastjson.demo\",\"cmd\":\"calc\"}}";
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.toString());
    }
}
