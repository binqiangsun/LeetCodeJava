package com.company.Interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sunbinqiang on 09/05/2018.
 */
public class DynamicProxyTest {

    public interface InterfaceObjcet {
        void doCore1(String command);
        void doCore2(String command);
    }

    public class RealObject implements InterfaceObjcet {

        public RealObject(){}

        @Override
        public void doCore1(String command) {
            System.out.println(command);
        }

        @Override
        public void doCore2(String command) {
            System.out.println(command);
        }
    }

    public class DoProxyHandler implements InvocationHandler {

        private Object proxied;

        public DoProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy do something");
            return method.invoke(proxied, args);
        }
    }

    public void test() {
        RealObject realObject = new RealObject();
        InterfaceObjcet proxy = (InterfaceObjcet) Proxy.newProxyInstance(InterfaceObjcet.class.getClassLoader(),
                new Class[]{InterfaceObjcet.class}, new DoProxyHandler(realObject));
        proxy.doCore1("command1");
    }

}
