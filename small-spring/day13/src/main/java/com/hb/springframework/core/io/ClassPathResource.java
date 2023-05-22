package com.hb.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import cn.hutool.core.lang.Assert;
import com.hb.springframework.utils.ClassUtils;

/**
 * @ClassName ClassPathResource
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/4 22:47
 * @Version 1.0
 */
public class ClassPathResource implements Resource {
    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
