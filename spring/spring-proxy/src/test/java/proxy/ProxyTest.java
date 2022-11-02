package proxy;

import org.junit.Test;
import spring.proxy.Calculator;
import spring.proxy.CalculatorImpl;
import spring.proxy.CalculatorStaticProxy;
import spring.proxy.ProxyFactory;

public class ProxyTest {
    /**
     * 动态代理：
     * 1.jdk动态代理：要求必须有接口，最终生成的代理类在com.sun.proxy包下，类名为$proxy+数字
     * 2.cglib动态代理：最终生成的代理类会继承目标类，并且和目标类在相同包下
     */
    @Test
    public void testProxy(){
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1, 2);
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);
    }
}
