package service;

import entity.SysDep;

import java.util.List;

public interface DepartmentService {
    List<SysDep> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean register(SysDep dep);

    boolean remove(Integer id);

    SysDep findByID(Integer depId);

    SysDep selectByName(String name);
}
