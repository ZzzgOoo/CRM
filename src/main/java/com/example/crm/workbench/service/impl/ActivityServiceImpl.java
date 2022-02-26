package com.example.crm.workbench.service.impl;

import com.example.crm.ov.PaginationOv;
import com.example.crm.settings.dao.UserDao;
import com.example.crm.settings.domain.User;
import com.example.crm.workbench.dao.ActivityDao;
import com.example.crm.workbench.domain.Activity;
import com.example.crm.workbench.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;
    @Override
    public List<User> queryAllUsers() {

        return activityDao.selectAllUsers();
    }

    @Override
    public int addActivity(String id, String owner, String name, String startDate, String endDate, String cost, String description, String createTime, String createBy) {
        StringBuilder str=new StringBuilder("1246742752752752753727277278242711");

        return activityDao.addActivity(id,owner,name,startDate,endDate,cost,description,createTime,createBy);
    }

    @Override
    public PaginationOv<Activity> selectRecord(String pageNumber,String pageSize,String name, String owner, String startDate, String endDate) {
        //pagesize:页面显示条数
        //pageNum:当前显示页数
        int pagesize= Integer.parseInt(pageSize);
        int pageNum= (Integer.parseInt(pageNumber)-1)*pagesize;

        PaginationOv<Activity> paginationOv=new PaginationOv<>();

        paginationOv.setTotal(activityDao.sum(name, owner, startDate, endDate));
        paginationOv.setDatalist(activityDao.conditionalSearch(pagesize, pageNum, name, owner, startDate, endDate));
        return paginationOv;
    }

    @Override
    public Activity detail(String id) {
        Activity activity=activityDao.detail(id);
        if (activity.getEditBy()!=null ){
          return   activityDao.detail2(id);
        }
        return activity;
    }

    @Override
    public int updateActivity(String id,String userid, String name, String startDate, String endDate, String cost, String description, String editTime, String editBy) {
        return activityDao.updateActivity(id,userid, name, startDate, endDate, cost, description, editTime, editBy);
    }
}
