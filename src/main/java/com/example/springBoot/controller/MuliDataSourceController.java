package com.example.springBoot.controller;

import com.example.springBoot.domain.Employee;
import com.example.springBoot.domain.MFirm;
import com.example.springBoot.mapper.test1.EmpMapper;
import com.example.springBoot.mapper.test2.MFirmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分库测试
 */
@RestController
public class MuliDataSourceController {

    @Autowired
    EmpMapper empMapper;
    @Autowired
    MFirmMapper mFirmMapper;

    @RequestMapping("/getEmployees")
    public List<Employee> getEmployees() {
        List<Employee> list = empMapper.getAll();
        return list;
    }
    @RequestMapping("/getMFirm")
    public List<MFirm> getMFirm() {
        List<MFirm> list = mFirmMapper.getAll();
        return list;
    }
}
