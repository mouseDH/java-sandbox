package com.halk.sandbox.runner;

import com.halk.sandbox.runner.plugin.MessageParser;
import com.halk.sandbox.runner.plugin.PluginLoader;

/**
 * @Author: hao.dai
 * @Project: java-sandbox
 * @Date: 2020/5/26 15:26
 * @Description:
 * @Godzilla.tech
 */
public class SandBoxRunner {

    protected Object execute(){
        PluginLoader loader = new PluginLoader();

        try {
            //根据条件获取类名全程
            Class<?> pluginClass = loader.loadClass("ByeFilePlugin");
            MessageParser parser = (MessageParser) pluginClass.newInstance();

           return parser.parse("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
