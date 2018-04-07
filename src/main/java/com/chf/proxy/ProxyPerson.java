package com.chf.proxy;

/**
 * ${DESCRIPTION}
 *
 * @author 温柔一刀
 * @create 2018-04-07 9:40
 **/
public class ProxyPerson implements Person {
    private  Person  target;
    public  ProxyPerson(Person target){
        this.target=target;
    }
    public void say() {
        System.out.println("Proxy start ....");
        target.say();
        System.out.println("Proxy end ....");

    }
}
