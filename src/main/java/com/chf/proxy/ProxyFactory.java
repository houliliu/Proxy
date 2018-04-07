package com.chf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ${DESCRIPTION}
 *
 * @author 温柔一刀
 * @create 2018-04-07 10:01
 **/
public class ProxyFactory {
    //目标
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }
    //给目标对象生成代理对象
    public Object getProxyInstance(){
        //使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)返回某个对象的代理对象
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                /**
                 * InvocationHandler接口只定义了一个invoke方法，因此对于这样的接口，我们不用单独去定义一个类来实现该接口，
                 * 而是直接使用一个匿名内部类来实现该接口，new InvocationHandler() {}就是针对InvocationHandler接口的匿名实现类
                 * 在invoke方法编码指定返回的代理对象干的工作
                 * proxy : 把代理对象自己传递进来
                 * method：把代理对象当前调用的方法传递进来
                 * args:把方法参数传递进来
                 *
                 * 当调用代理对象的方法时，
                 * 实际上执行的都是invoke方法里面的代码，
                 * 因此我们可以在invoke方法中使用method.getName()就可以知道当前调用的是代理对象的哪个方法
                 */
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("————————————————————————Proxy start");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("————————————————————————Proxy end  ");
                        return returnValue;
                    }
                }
        );
    }
}
