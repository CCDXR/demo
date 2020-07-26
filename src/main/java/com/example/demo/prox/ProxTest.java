package com.example.demo.prox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxTest implements InvocationHandler {
    Son son;

    public Object bind(Son son) {
        this.son = son;
        /*返回的是一个实现了son.getClass().getInterfaces()这个接口的代理后的对象，
            this只是用于实现InvocationHandler.invoke接口的对象，这个对象作为
        * 生成的代理后的对象的一个内部属性，并且通过构造方法初始化*/

        return Proxy.newProxyInstance(son.getClass().getClassLoader(),
                son.getClass().getInterfaces(),  this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret;
        System.out.println("proxy invoke");
        ret = method.invoke(son, args);
        System.out.println("hahaha");
        return ret;
    }
}
