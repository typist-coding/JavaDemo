package service;

import com.github.pagehelper.PageInfo;
import pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}

