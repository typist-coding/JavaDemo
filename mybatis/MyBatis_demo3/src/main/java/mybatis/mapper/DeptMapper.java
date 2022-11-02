package mybatis.mapper;

import mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * step1：查询部门信息
     * step2：
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

    /**
     * 获取部门以及部门中所有的员工信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * step1：查询员工信息
     * step2：通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);


}
