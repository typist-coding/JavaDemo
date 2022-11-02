package mybatis.test;

import mybatis.mapper.ParameterMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的两种方式：
     * 1.${}字符串拼接
     * 2.#{}占位符赋值
     *
     * MyBatis获取参数值的各种情况
     * 1.mapper接口方法的参数为单个的字面量类型
     *   可以通过#{}和${}以任意的字符串获取参数值，但是需要注意${}的单引号问题
     * 2.mapper接口方法的参数为多个时
     *   此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *   ①以arg0,arg1...为键，以参照为值
     *   ②以param1,param2...为键，以参照为值
     *   因此只需要通过#{}和以${}为键的方式访问值即可，但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     *   只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4.mapper接口方法的参数是一个实体类类型的参数
     *   只需要通过#{}和${}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     * 5.使用@Param注解命名参数
     *      此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *      *   ①以@param注解的值为键，以参照为值
     *      *   ②以param1,param2...为键，以参照为值
     *   因此只需要通过#{}和以${}为键的方式访问值即可，但是需要注意${}的单引号问题
     */

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("张三", "123456");
        System.out.println(user);
    }


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李四", "123", 23, "男", "123@qq.com"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","张三");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("张三", "123456");
        System.out.println(user);
    }

    @Test
    public void GetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
    @Test
    public void testJDBC() throws Exception {
        String username = "admin";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "hiahiahia0");
//        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = '"+username+"'");
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = ?");
        ps.setString(1,username);
    }
}
