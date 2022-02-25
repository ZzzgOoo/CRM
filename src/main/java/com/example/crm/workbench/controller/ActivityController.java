package com.example.crm.workbench.controller;

import com.example.crm.ov.PaginationOv;
import com.example.crm.settings.domain.User;
import com.example.crm.workbench.domain.Activity;
import com.example.crm.workbench.service.ActivityService;
import com.example.utils.DateTimeUtil;
import com.example.utils.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ActivityController {
    @Resource
    private ActivityService activityService;
    private User user;
    private Activity activity;
    private PaginationOv<Activity> paginationOv;


    //获取所有用户信息，传递到前端页面
    @RequestMapping("/addBtnActivityModel")
    @ResponseBody
    public List<User> query(HttpServletRequest request){
        String str= (String) request.getSession().getAttribute("name");
        return activityService.queryAllUsers();
    }

    //访问Activity/index.html页面
    @RequestMapping("/activity/index.html")
    public String Activity_index(){
        return "/workbench/activity/index";
    }


    //Activity/index.html保存市场活动的功能实现
    @RequestMapping("/addActivity")
    @ResponseBody
    public int addActivity(HttpServletRequest request,String owner,String name,String startDate,String endDate,String cost,String description){
        User user1= (User) request.getSession().getAttribute("user");

         return activityService.addActivity(UUIDUtil.getUUID(),owner,name,startDate,endDate,cost,description,
                DateTimeUtil.getSysTime(),user1.getName());
    }


    @RequestMapping("/detail.html")
    public String detail(){
        return "workbench/activity/detail";
    }


    //查询页面所有记录
    @RequestMapping("/selectActivityData")
    @ResponseBody
    public PaginationOv<Activity> pagination(String pageNumber,String pageSize,String name,String owner,String startDate,String endDate,HttpServletRequest request){

        paginationOv=activityService.selectRecord(pageNumber,pageSize,name, owner, startDate, endDate);
        return paginationOv;
    }


    //删除
    @RequestMapping("/deleteActivity")
    @ResponseBody
    public String deleteActivity(String activityId){
        String[] attr=activityId.split(",");
        for (int a=0;a<attr.length;a++){
            System.out.println(attr[a]);
        }
        return "1";
    }


    //详细页
    @RequestMapping("/detail")
    @ResponseBody
    public Activity detail(String id){

        return activityService.detail(id);

    }

    //更新Activity
    @RequestMapping("/updateActivity")
    @ResponseBody
    public int updateActivity(String id,String name,String startDate,String endDate,String cost,String description){

        return 1;
    }
}