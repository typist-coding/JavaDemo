package mybatis.test;

import mybatis.mapper.CacheMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis缓存查询顺序
 * 二级缓存——>一级缓存——>数据库
 *
 * SqlSession关闭后，一级缓存中的数据会写入二级缓存
 */

public class CacheMapperTest {

    /**
     * 二级缓存：SqlSessionFactory
     *
     * 二级缓存开启的条件
     * 1.在核心配置文件中，设置全局配置settings属性cacheEnabled="true"，默认为true，不需要设置
     * 2.在映射文件中设置标签<cache/>
     * 3.二级缓存必须在SqlSession关闭或提交之后有效
     * 4.查询的数据所转换的实体类必须实现序列化的接口
     *
     * 二级缓存失效的情况
     * 两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */

    @Test
    public void testTwoCache(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 一级缓存：SqlSession级别(默认开启一级缓存)
     *
     * 一级缓存失效的四种情况
     * 1.不同的SqlSession对应不同的一级缓存
     * 2.同一个SqlSession但是查询条件不同
     * 3.同一个SqlSession两次查询期间执行了任何一次0
     * 4.同一个SqlSession两次查询期间手动清空了缓存
     *
     */

    @Test
    public void testOneCache(){
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        CatchMapper mapper = sqlSession.getMapper(CacheMapper.class);
//        Emp emp = mapper.getEmpByEid(1);
//        System.out.println(emp);

        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);
//        mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com"));
        sqlSession1.clearCache();
        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
    }
}
