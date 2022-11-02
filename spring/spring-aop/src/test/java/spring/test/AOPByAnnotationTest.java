package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.annotation.Calculator;

public class AOPByAnnotationTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //false
//        CalculatorImpl calculator = ioc.getBean(CalculatorImpl.class);
//        calculator.add(1,1);
        //true
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10,1);
    }
}
