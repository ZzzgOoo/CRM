package com.example.crm.settings.web.controller;

import com.example.crm.settings.domain.User;
import com.example.crm.settings.service.UserService;
import com.example.utils.MyException;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class UserController {

    @Resource
    private UserService userService;
    private User user;
    //页面初始化
    @RequestMapping("/login.html")
    public String Initialization(){
        return "login";
    }
    //登录
    @RequestMapping("login")
    @ResponseBody
    public  String Login( String loginAct, String loginPwd,HttpServletRequest request) throws UnknownHostException, MyException {
        try {
            user=userService.Login(loginAct,loginPwd);
            if (user!=null){
                request.getSession().setAttribute("user",user);
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return "true";
    }
    @RequestMapping("/workbench/index.html")
    public String WorkBench(){
        return "/workbench/index";
    }

}
