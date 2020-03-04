package com.collegesystem.accountsvc.repo;

import com.collegesystem.accountsvc.model.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository//表示访问数据库
public interface StaffRepo {
    public List<Staff> getStaffs();

}
