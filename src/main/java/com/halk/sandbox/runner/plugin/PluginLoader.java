package com.halk.sandbox.runner.plugin;

/**
 * @Author: hao.dai
 * @Project: java-sandbox
 * @Date: 2020/5/26 15:33
 * @Description:
 * @Godzilla.tech
 */
public class PluginLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // Is the class already loaded?
        Class<?> pluginClass = findLoadedClass(name);

        // Is it a system class?
        if (pluginClass == null) {
            pluginClass = findSystemClass(name);
        }

        // If none of the above, read from the corresponding .class file.
        if (pluginClass == null) {

            byte[] fileContent = acquireClassContent(name);
            pluginClass = defineClass(name, fileContent, 0, fileContent.length);
            resolveClass(pluginClass);
        }

        return pluginClass;
    }

    private byte[] acquireClassContent(String name) {
        return null;
    }
}