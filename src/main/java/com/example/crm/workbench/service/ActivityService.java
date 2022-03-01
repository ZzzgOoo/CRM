package com.example.crm.workbench.service;

import com.example.crm.ov.PaginationOv;
import com.example.crm.settings.domain.User;
import com.example.crm.workbench.domain.Activity;

import java.util.List;

public interface ActivityService {
    List<User> queryAllUsers();
    int addActivity(String id,
                    String owner,
                    String name,
                    String startDate,
                    String endDate,
                    String cost,
                    String description,
                    String createTime,
                    String createBy);
    //查询记录条数与分页数据
    PaginationOv<Activity> selectRecord(String pageNumber,String pageSize,String name, String owner, String startDate, String endDate);
    //detail页面详细信息
    Activity detail(String id);
    //详细信息查询
    int updateActivity(String id,String userid, String name, String startDate, String endDate, String cost, String description, String editTime, String editBy);
    //删除
    int delete(String[] id);
}
