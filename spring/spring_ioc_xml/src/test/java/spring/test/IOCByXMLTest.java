package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.Clazz;
import spring.pojo.Student;

public class IOCByXMLTest {

    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = (Student)ioc.getBean("studentSix");
        System.out.println(student);

//        Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
//        System.out.println(clazz);

//        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazz);

    }

    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student studentOne = (Student)ioc.getBean("studentOne");
        System.out.println(studentOne);
    }
}
