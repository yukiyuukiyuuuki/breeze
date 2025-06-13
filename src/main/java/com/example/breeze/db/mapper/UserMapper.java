package com.example.breeze.db.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.breeze.dataformat.entity.User;

@Mapper
public interface UserMapper {
  @Select("SELECT user_id, name, password, subscribe_date FROM users WHERE user_id = #{id}")
  User selectUserById(long id);

  @Select("SELECT user_id, name, password, subscribe_date FROM users WHERE name = #{username}")
  User selectUserByUsername(String username);

  @Insert("INSERT INTO users (name, password) VALUES (#{name}, #{password})")
  @Options(useGeneratedKeys = true, keyProperty = "userId")
  void insertUser(User user);

  @Delete("DELETE FROM users WHERE user_id = #{userId}")
  void deleteUser(long userId);

}
