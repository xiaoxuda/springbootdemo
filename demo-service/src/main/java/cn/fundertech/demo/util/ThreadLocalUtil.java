package cn.fundertech.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoxuda 2020-02-03
 **/
public class ThreadLocalUtil {

    /**
     * 在api入口处保存rpcContext.attach
     */
    private static ThreadLocal<Map<String, String>> apiAttachThreadLocal = new ThreadLocal<>();

    public static void setApiRpcContextAttach(Map<String, String> attachMap){
        apiAttachThreadLocal.set(new HashMap<>(attachMap));
    }

    public static String getApiRpcContextAttach(String attachKey){
        Map<String, String> attachMap = apiAttachThreadLocal.get();
        if(attachMap != null){
            return attachMap.get(attachKey);
        }
        return null;
    }
}