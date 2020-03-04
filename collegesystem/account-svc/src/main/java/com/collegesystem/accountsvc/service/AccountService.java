package com.collegesystem.accountsvc.service;

import com.collegesystem.accountsvc.model.Staff;
import com.collegesystem.accountsvc.repo.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    StaffRepo staffRepo;

    public List<Staff> getStaffs(){
        return this.staffRepo.getStaffs();
    }
}
