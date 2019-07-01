package com.study.test02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.study.entity.User;

public interface UserMapperTest02 {
    // ≤È—Ø”Ôæ‰
    @Select("SELECT * FROM T_USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    // ÃÌº”
    @Insert("INSERT INTO T_USER(NAME, AGE,EMAIL) VALUES(#{name}, #{age}, #{email})")
    int insert(@Param("name") String name, @Param("age") Integer age,@Param("email") String email);
}
