package service;

import entity.SysDep;

import java.util.List;

public interface DepartmentService {
    List<SysDep> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();
}
