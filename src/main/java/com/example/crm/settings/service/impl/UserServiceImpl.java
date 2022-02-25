package com.example.crm.settings.service.impl;

import com.example.crm.settings.dao.UserDao;
import com.example.crm.settings.domain.User;
import com.example.crm.settings.service.UserService;
import com.example.utils.DateTimeUtil;
import com.example.utils.MD5Util;
import com.example.utils.MyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User Login(String loginAct, String loginPwd) throws UnknownHostException, MyException {
        //用户密码使用MD5加密后再进行判断比较
        loginPwd=MD5Util.getMD5(loginPwd);
        User user=userDao.Login(loginAct,loginPwd);
        //获取当前访问者的IP地址
        String Ip= InetAddress.getLocalHost().getHostAddress();
        if (userDao.Login(loginAct,loginPwd)!=null){
            //获取允许登录的IP地址信息
            String str=user.getAllowIps();
            //判断当前登录地址是否为允许登录地址
            //contains：是否包含某个字符串
            if (!str.contains(Ip)){
                throw new MyException("当前登录地址非法,禁止访问！");
            }
            //判断当前账户的expireTime(失效时间)
            if (user.getExpireTime().compareTo(DateTimeUtil.getSysTime())<0){
                throw new MyException("当前账户已失效，请联系管理员");
            }
            return user;
        }
        throw new MyException("用户名或密码错误，请确认后重试！");
    }

}
