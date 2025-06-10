package com.example.breeze.mapper;

import com.example.breeze.entity.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT user_id, name, password, subscribe_date FROM user WHERE user_id = #{id}")
  User selectUserById(long id);

  @Insert("INSERT INTO user (name, password, subscribe_date) VALUES (#{name}, #{password}, #{subscribe_date})")
  void insertUser(User user);

  @Delete("DELETE FROM user")
  void deleteUser(long userId);

}
