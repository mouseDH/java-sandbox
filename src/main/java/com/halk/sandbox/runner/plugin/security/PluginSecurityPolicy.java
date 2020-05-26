package com.halk.sandbox.runner.plugin.security;

import com.halk.sandbox.runner.plugin.PluginLoader;
import sun.security.util.SecurityConstants;

import java.io.FilePermission;
import java.security.*;

/**
 * @Author: hao.dai
 * @Project: java-sandbox
 * @Date: 2020/5/26 15:32
 * @Description:
 * @Godzilla.tech
 */
public class PluginSecurityPolicy extends Policy {
    @Override
    public PermissionCollection getPermissions(ProtectionDomain domain) {
        Permissions permissions = new Permissions();

        //自定义类加载器权限控制
        if (domain.getClassLoader() instanceof PluginLoader) {  // if it's a plugin

        } else {//其它系统级类加载器权限控制
            permissions.add(new AllPermission());  // give all permissions to other classes
        }

        return permissions;
    }
}
