package com.mybatisboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatisboot.entity.User;

@Mapper
public interface UserMapper {
    @Insert("insert into app_user(sso_id,password,first_name,last_name,email,state) "
            + "values(#{ssoId},#{password},#{firstName},#{lastName},#{email},#{state})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int save(User user);

    //	@Select("select u.id as id,u.sso_id as ssoId,u.password as password,u.first_name as first_name,u.last_name as last_name,u.email as email,u.state as state "
//			+ " from app_user u where u.id = #{id}")
//	@Results({ @Result(id = true, column = "id", property = "id"),
//		@Result(column = "sso_id", property = "ssoId"),
//		@Result(column = "password", property = "password"),
//		@Result(column = "first_name", property = "firstName"),
//		@Result(column = "last_name", property = "lastName"),
//		@Result(column = "email", property = "email"),
//		@Result(column = "state", property = "state"),
//		@Result(property = "userProfiles", column = "id", many = @Many(select = "com.mybatisboot.mapper.UserProfileMapper.findUserProfileByUserId")) 
//	})
    User queryById(int id);

    User queryBySsoId(String ssoid);

    int updateById(User user);

    int deleteById(Integer id);

    List<User> queryAll();

    List<User> queryByPage(Integer page, Integer pageSize);
}
