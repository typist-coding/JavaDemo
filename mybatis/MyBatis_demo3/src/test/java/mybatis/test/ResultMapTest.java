package mybatis.test;

import mybatis.mapper.DeptMapper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {

    /**
     * 解决字段名与属性名不一致的情况
     * 1.为字段名起别名，保持和属性名的一致
     * 2.设置全局配置，将_自动映射为驼峰
     *      <setting name="mapUnderscoreToCamelCase" value="true"/>
     * 3.通过resultMap设置自定义的映射关系
     *      <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *      </resultMap>
     */

    /**
     * 处理多对一的映射关系
     * 1.级联属性赋值
     * 2.association
     * 3.分步查询
     *
     * 处理一对多的映射关系
     * 1.collection
     * 2.分步查询
     * 3.
     */

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println("*******************");
        System.out.println(emp.getDept());
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(3);
        System.out.println(emp);
    }

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

}
