package com.example.crm.settings.dao;

import com.example.crm.settings.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User Login(String loginAct,String loginPwd);
}
