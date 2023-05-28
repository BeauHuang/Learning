package com.hb.springframework.beans.factory;

/**
 * @ClassName DisposableBean
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/10 22:58
 * @Version 1.0
 */

/**
 * Interface to be implemented by beans that want to release resources
 * on destruction. A BeanFactory is supposed to invoke the destroy
 * method if it disposes a cached singleton. An application context
 * is supposed to dispose all of its singletons on close.
 * <p>
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
