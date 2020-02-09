package cn.fundertech.demo.util;

import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 拦截并统一缓存请求携带的隐式参数
 * @author xiaoxuda 2020/2/3
 */
public class AttachmentFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Class invokerClass = invoker.getClass();
            Field invokerField = invokerClass.getDeclaredField("invoker");
            invokerField.setAccessible(true);
            Object attrInvoker = invokerField.get(invoker);

            Class subInvokerClass = attrInvoker.getClass();
            Field subInvokerField = subInvokerClass.getDeclaredField("invoker");
            subInvokerField.setAccessible(true);
            Object subAttrInvoker = subInvokerField.get(attrInvoker);

            Class thirdInvoker = subAttrInvoker.getClass().getSuperclass();
            Field implProxyField = thirdInvoker.getDeclaredField("proxy");
            implProxyField.setAccessible(true);
            Object implProxy = implProxyField.get(subAttrInvoker);

            Method method = implProxy.getClass().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            CacheRpcAttachment cacheRpcAttachment = method.getAnnotation(CacheRpcAttachment.class);
            if(cacheRpcAttachment != null){
                ThreadLocalUtil.setApiRpcContextAttach(invocation.getAttachments());
            }
        } catch (Exception e) {
            //do nothing
            e.printStackTrace(System.out);
        }
        return invoker.invoke(invocation);
    }
}
