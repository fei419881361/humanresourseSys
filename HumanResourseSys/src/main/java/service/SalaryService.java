package service;

import entity.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean remove(Integer id);

    boolean register(Salary salary);

    boolean update(Salary salary);

    Salary find(Integer id);

    List<Salary> findByEId(Integer id);
}
