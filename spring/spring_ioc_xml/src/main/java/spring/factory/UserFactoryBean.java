package spring.factory;

import org.springframework.beans.factory.FactoryBean;
import spring.pojo.User;

/**
 * FactoryBean是一个接口，需要创建一个类实现该接口
 *
 * 三个方法：
 * getObject()：通过一个对象交给IOC容器管理
 * getObjectType()：设置所提供的对象的类型
 * isSingleton()：所提供对象是否单例
 *
 * 当吧FactoryBean的实现类配置为bean时，会将当前类中的getObject()所返回的对象交给IOC容器管理
 */

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
