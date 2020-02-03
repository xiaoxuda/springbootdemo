package cn.fundertech.demo.util;

import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

/**
 * 拦截并统一缓存请求携带的隐式参数
 * @author xiaoxuda 2020/2/3
 */
public class AttachmentFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        ThreadLocalUtil.setApiRpcContextAttach(invocation.getAttachments());
        return invoker.invoke(invocation);
    }
}
