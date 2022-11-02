package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * step1：查询部门信息
     * step2：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);


    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * step1：查询员工信息
     * step2：通过did查询员工所对应的部门
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();
}
