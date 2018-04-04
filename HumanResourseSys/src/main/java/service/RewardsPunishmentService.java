package service;

import entity.RewardsPunishment;

import java.util.List;

public interface RewardsPunishmentService {
    List<RewardsPunishment> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean remove(Integer id);

    boolean register(RewardsPunishment rewardsPunishment);

    boolean update(RewardsPunishment rewardsPunishment);
}
