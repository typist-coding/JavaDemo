package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.xml.Calculator;

public class AOPByXMLTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,1);
    }
}
