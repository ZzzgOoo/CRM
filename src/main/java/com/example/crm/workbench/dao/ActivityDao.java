package com.example.crm.workbench.dao;

import com.example.crm.ov.PaginationOv;
import com.example.crm.settings.domain.User;
import com.example.crm.workbench.domain.Activity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ActivityDao {
    List<User> selectAllUsers();
    int addActivity(String id,
                    String owner,
                    String name,
                    String startDate,
                    String endDate,
                    String cost,
                    String description,
                    String createTime,
                    String createBy);
    //统计数据条数
    int  sum(String name,String owner,String startDate,String endDate);
    //conditional search:条件查找
    List<Activity> conditionalSearch(int pagesize,int pageNum,String name,String owner,String startDate,String endDate);
    Activity detail(String id);
}
