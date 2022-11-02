package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

    /**
     * 添加用户信息
     */
    void insertUser(User user);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);
}
