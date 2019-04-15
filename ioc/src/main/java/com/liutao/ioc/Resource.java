package com.liutao.ioc;

import java.io.InputStream;

/**
 * 资源定义
 * @author: LIUTAO
 * @Date: Created in 2018/9/18  10:50
 * @Modified By:
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
