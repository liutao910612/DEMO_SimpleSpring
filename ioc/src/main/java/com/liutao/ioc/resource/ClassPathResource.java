package com.liutao.ioc.resource;

import java.io.InputStream;

/**
 * @author: LIUTAO
 * @Date: Created in 2019/4/15  11:28
 * @Modified By:
 */
public class ClassPathResource extends AbstractResource{
    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader;
    }

    @Override
    public InputStream getInputStream() throws Exception {

        return null;
    }
}
