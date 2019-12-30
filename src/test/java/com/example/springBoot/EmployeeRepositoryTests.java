package com.example.springBoot;

import com.example.springBoot.domain.Employee;
import com.example.springBoot.mapper.EmployeeMapper;
import com.example.springBoot.service.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class})
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test(){
//        Employee employee = new Employee();
//        employee.setName("xxx");
//        employee.setAddress("北京");
//        employee.setPosition("老板");
//        employeeRepository.save(employee);

        List<Employee> all = employeeRepository.findAll();
        all.forEach(a ->System.out.println(a));

        Employee employee = employeeRepository.findByName("张三");
        System.out.println(employee);

        List<Employee> employees = employeeRepository.findByNameOrAddress("张三","北京");
        employees.forEach(a->System.out.println(a));
    }

    @Test
    public void testPageQuery() throws Exception {
        int page=1,size=3;
        Pageable pageable = new PageRequest(page, size);
        Page<Employee> all = employeeRepository.findAll(pageable);
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
        List<Employee> list = all.getContent();
        list.forEach(a ->System.out.println(a));
    }

    @Test
    public void testQuery() throws Exception {
        Employee employee = new Employee();
        employee.setName("杨帆");
        employee.setAddress("宁夏");
        employee.setPosition("员工");
        employeeMapper.insert(employee);

        List<Employee> list = employeeMapper.getAll();
        list.forEach(a ->System.out.println(a));

//        Employee employee = employeeMapper.getOne(121l);
//        System.out.println("更新前："+employee);
//        employee.setName("赵六");
//        employeeMapper.update(employee);
//        employee = employeeMapper.getOne(121l);
//        System.out.println("更新后："+employee);

    }
}
