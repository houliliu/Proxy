package com.chf.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author 温柔一刀
 * @create 2018-04-07 10:33
 **/
public class CglibProxyFactory  implements MethodInterceptor {
    private  Object target;
    public  CglibProxyFactory(Object target){
        this.target=target;
    }

    public  Object getProxyInstance(){
        // 工具类
        Enhancer enhancer= new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //回调函数
        enhancer.setCallback(this);
        //创建子类
        return  enhancer.create();

    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("—————————cglib———————————————Proxy start");
        //执行目标对象方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("———————————cglib—————————————Proxy end  ");
        return returnValue;
    }
}
