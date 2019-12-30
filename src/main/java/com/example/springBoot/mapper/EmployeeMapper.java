package com.example.springBoot.mapper;

import com.example.springBoot.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM Employee")
    @Results({
            @Result(property = "name",  column = "name"),
            @Result(property = "address", column = "address")
    })
    List<Employee> getAll();

    Employee getOne(Long id);

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Long id);
}
