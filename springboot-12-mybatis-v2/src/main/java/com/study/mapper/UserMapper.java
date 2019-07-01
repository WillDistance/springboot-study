package com.study.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.study.entity.User;

public interface UserMapper {
	@Select("select * from t_user where name = #{name}")
	User findByName(@Param("name") String name);

	@Insert("insert into t_user(name, email) values(#{name}, #{email})")
	int insert(@Param("name") String name, @Param("email") String email);
}
