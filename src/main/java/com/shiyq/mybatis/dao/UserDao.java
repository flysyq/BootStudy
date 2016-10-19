package com.shiyq.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shiyq.mybatis.domain.User;

@Mapper
public interface UserDao {
    public int insert(User user);
    public int update(User user);
    public int delete(String user_name);
    public List<User> selectAll();
    public int countAll();
    public User findByUserName(String user_name);
}
