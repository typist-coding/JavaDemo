package mybatis.mapper;

import mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致：
     * 1.映射文件的namespace要和mapper接口的全类名保持一致
     * 2.映射文件的sql语句的id要和mapper接口中的方法名一致
     */
    //添加
    int insertUser();

    //修改
    void updateUser();

    //删除
    void deleteUser();

    //根据id查询用户信息
    User getUserById();

    //查询所有用户信息
    List<User> getAllUser();

}
