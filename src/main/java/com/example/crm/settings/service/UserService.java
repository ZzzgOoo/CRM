package com.example.crm.settings.service;

import com.example.crm.settings.domain.User;
import com.example.utils.MyException;

import java.net.UnknownHostException;
import java.util.List;

public interface UserService {
    User Login(String loginAct,String loginPwd) throws UnknownHostException, MyException;

}
