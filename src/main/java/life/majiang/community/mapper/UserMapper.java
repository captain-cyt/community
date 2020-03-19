package life.majiang.community.mapper;


import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

/**
 * @author c_sir
 * @create 2020-03-07 13:03
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
        //当形参是类类型的话，注解会直接把这个类类型的变量放进上一句#{xxx}中作为变量，如果是普通类型，写法为：@Param("xxx")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User finById(@Param("id") Integer id);
}
