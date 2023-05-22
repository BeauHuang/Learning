package com.hb.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

import cn.hutool.core.lang.Assert;

/**
 * @ClassName DefaultResourceLoader
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/4 22:52
 * @Version 1.0
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            }
            catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
