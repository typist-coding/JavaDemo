package mybatis.test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
            //根据条件查询
//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
//            example.or().andDidIsNotNull();
//            List<Emp> list1 = mapper.selectByExample(example);
//            list1.forEach(emp -> System.out.println(emp));
            mapper.updateByPrimaryKey(new Emp(1,"admin",null,"女","456@qq.com",3));
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",null,"女","456@qq.com",3));//选择性修改
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
