package com.liutao.ioc;

import com.liutao.ioc.resource.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/9/10  15:48
 * @Modified By:
 */
public class ResourceUrl implements Resource {

    private final URL url;

    public ResourceUrl(URL url) {
        this.url = url;
    }


    public URL getURL() {
        return url;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
