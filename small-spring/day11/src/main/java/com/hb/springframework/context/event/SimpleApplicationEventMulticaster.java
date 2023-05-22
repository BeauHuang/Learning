package com.hb.springframework.context.event;


import com.hb.springframework.beans.factory.BeanFactory;
import com.hb.springframework.context.ApplicationEvent;
import com.hb.springframework.context.ApplicationListener;

/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface.
 * <p>
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
