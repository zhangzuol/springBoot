package com.example.springBoot;

import com.example.springBoot.domain.Employee;
import com.example.springBoot.mapper.test1.EmpMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class})
public class EmpTest {

    @Autowired
    EmpMapper empMapper;

    @Test
    public void getAll(){
        PageHelper.startPage(1,3);
        List<Employee> list = empMapper.getAll();
        PageInfo<Employee> page = new PageInfo<>(list);
        System.out.println("总页：" + page.getPages());
        System.out.println("总记录条数为："+page.getTotal());
    }
}
