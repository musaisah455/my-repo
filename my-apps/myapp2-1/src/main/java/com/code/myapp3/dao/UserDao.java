package com.code.myapp3.dao;

import com.code.myapp3.entity.UserDetail;

import java.util.List;

public interface UserDao {

    void save(UserDetail theUserDetail);

    UserDetail findById(Object username);

    List<UserDetail> findAll();

    void update(UserDetail theUserDetail);
}
