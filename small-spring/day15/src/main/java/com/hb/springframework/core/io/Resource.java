package com.hb.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Resource
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/4 22:46
 * @Version 1.0
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
