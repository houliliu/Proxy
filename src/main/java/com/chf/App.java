package com.chf;

import com.chf.proxy.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //目标
        Boy person= new Boy();
        System.out.println( "静态 Proxy test !" );
        //建立代理
        ProxyPerson proxyPerson=new ProxyPerson(person);
        //执行代理方法
        proxyPerson.say();


       //jdk 动态代理
        System.out.println( "动态代理 Proxy test !" );
        //目标
        //建立代理
        Person proxyFactory = (Person) new ProxyFactory(person).getProxyInstance();
       //代理对象 class com.sun.proxy.$Proxy0
        System.out.println(proxyFactory.getClass());
        //执行代理方法
        proxyFactory.say();

        //cglib 代理
        Person cglibproxyFactory = (Person) new CglibProxyFactory(person).getProxyInstance();
        //代理对象 com.chf.proxy.Boy$$EnhancerByCGLIB$$a1a0404c
        System.out.println(cglibproxyFactory.getClass());
        //执行代理方法
        cglibproxyFactory.say();

    }
}
