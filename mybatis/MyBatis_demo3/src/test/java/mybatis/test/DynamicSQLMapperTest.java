package mybatis.test;

import mybatis.mapper.DynamicSQLMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    /**
     * 动态SQL
     * 1.if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到sql中
     * 2.where：
     *  ①当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
     *  ②当where标签中没有内容时，此时where标签没有任何效果
     *  注意：where标签不能将内容后多余的and或or去掉
     * 3.trim：
     *  ①若标签中有内容时：
     *  prefix|suffix：将trim标签中内容前面或后面添加指定内容
     *  prefixOverrides|suffixOverrides：将trim标签中内容前面或后面去掉指定内容
     *  ②若标签中没有内容时，trim标签也没有任何效果
     * 4.choose,when,otherwise,相当于if...else if...else
     *  when至少要有一个，otherwise最多只能有一个
     * 5.foreach
     *  collection：设置需要循环的数组或集合
     *  item：表示数组或集合中的每一个数据
     *  separator：循环体之间的分隔符
     *  open：foreach标签所循环的所有内容的开始符
     *  close：foreach标签所循环的所有内容的结束符
     * 6.sql标签
     * 设置：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用：<include refid="empColumns"></include>
     */

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(emps));
    }

    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三", 23, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", null, "", ""));
        System.out.println(list);
    }
}
