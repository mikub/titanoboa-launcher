package io.titanoboa.launcher;

import io.titanoboa.Startable;
import io.titanoboa.cloader.DynamicClassLoader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;


/**
 * Launcher for titanoboa server
 * Created by miro on 12/3/18.
 *
 * java -jar titanoboa-cloader-0.1.0.jar file:/home/miro/work/titanoboa/titanoboa-lite/target/titanoboa.jar
 */


public class Runtime {

    public static Startable instantiateServer(ClassLoader classLoader, String startableClazz) {
        Startable server;
        try {
            Class serverClass = classLoader
                    .loadClass(startableClazz);
            server = (Startable)serverClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Cannot load titanoboa.server!", e);
        }
        return server;
    }

    public static Startable instantiateServer(ClassLoader classLoader) {
       return instantiateServer (classLoader, "titanoboa.server");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        URL[] urls = {new URL(args[0])};
        DynamicClassLoader cl = new DynamicClassLoader(urls, Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(cl);
        Startable titanoboaServerRuntime = args.length>1 ? instantiateServer(cl,args[1]) : instantiateServer(cl);
        titanoboaServerRuntime.start();
    }

}
