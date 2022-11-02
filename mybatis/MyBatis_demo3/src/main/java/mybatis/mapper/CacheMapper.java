package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    void insertEmp(Emp emp);

    Emp getEmpByEid(@Param("eid") Integer eid);
}
