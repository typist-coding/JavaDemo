package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.controller.UserController;
import spring.dao.UserDao;
import spring.service.UserService;

public class IOCByAnnotationTest {

    /**
     * @Conponent：普通组件
     * @Controller：控制层组件
     * @Service：业务层组件
     * @Repository：持久层组件
     *
     * 通过注解+扫描所设置的bean的id，默认值为类的小驼峰。即类名的首字母为小写的结果
     * 可以通过标志组件的注解的value属性值设置bean的自定义的id
     *
     * @Autowired：实现自动装配功能的注解
     * 1.@Autowired注解能够标识的位置
     * ①标识在成员变量上，此时不需要设置成员变量的set方法
     * ②标识在set方法上
     * ③标识在为当前成员变量赋值的有参构造上
     * 2.@Autowired注解的原理
     * ①默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     * ②若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     *  即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
     * ③若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean
     *  且这些bean的id和要赋值的属性的属性名都不一致，此时抛异常NoUnique...
     * ④此时可以在要赋值的属性上，添加一个注解@Qualifier
     *  通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");

//        UserController userController = ioc.getBean("userController",UserController.class);
        UserController userController = ioc.getBean("controller",UserController.class);
//        System.out.println(userController);
//
//        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
//        System.out.println(userService);
//
//        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
//        System.out.println(userDao);
        userController.saveUser();

    }
}
