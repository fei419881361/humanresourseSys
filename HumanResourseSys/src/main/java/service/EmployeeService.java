package service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean remove(Integer id);

    boolean register(Employee employee);


    boolean update(Employee employee);

    int selectByDepName(Integer depId);
}
