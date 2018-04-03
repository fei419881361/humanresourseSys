package service;

import entity.Train;

import java.util.List;

public interface TrainService {
    List<Train> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean remove(Integer id);

    boolean register(Train train);

    boolean update(Train train);
}
