package cn.fundertech.demo.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在dubbo接口入口处缓存dubbo rpc的隐式参数
 * @author xiaoxuda 2020/2/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CacheRpcAttachment {
}
