package service;

import entity.Recruitment;

import java.util.List;

public interface RecruitmentService {
    List<Recruitment> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean remove(Integer id);

    boolean register(Recruitment recruitment);


    boolean update(Recruitment recruitment);
}
