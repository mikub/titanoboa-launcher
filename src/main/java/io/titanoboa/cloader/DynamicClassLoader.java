package io.titanoboa.cloader;

import java.net.URL;
import java.net.URLClassLoader;

public class DynamicClassLoader extends URLClassLoader {

    public DynamicClassLoader() {
        super(new URL[0], Thread.currentThread().getContextClassLoader() != null && Thread.currentThread().getContextClassLoader() != ClassLoader.getSystemClassLoader()?Thread.currentThread().getContextClassLoader():Compiler.class.getClassLoader());
    }

    public DynamicClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }

    public DynamicClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public void addURL(URL url) {
        super.addURL(url);
    }
}
