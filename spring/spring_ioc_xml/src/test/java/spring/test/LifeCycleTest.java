package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.User;

public class LifeCycleTest {
    /**
     * 生命周期1：实例化
     * 生命周期2：依赖注入
     * postProcessBeforeInitialization
     * 生命周期3：初始化
     * postProcessAfterInitialization
     * 生命周期4：销毁 IOC容器关闭时销毁，需要通过bean的destroy-method属性指定销毁的方法
     *
     * 注意：
     * 若bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
     * 若bean的作用域为多例时，生命周期的前三个步骤会在获取bean时执行
     *
     * bean的后置处理器会在生命周期的初始化前后添加额外的操作
     * 需要实现BeanPostProcessor接口，且配置到IOC容器中
     * 需要注意的是，bean后置处理器不是单独针对某一个bean生效
     * 而是针对IOC容器中所有bean执行
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
