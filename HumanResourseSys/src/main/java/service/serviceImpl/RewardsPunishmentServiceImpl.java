package service.serviceImpl;

import dao.RewardsPunishmentMapper;
import entity.RewardsPunishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.RewardsPunishmentService;

import java.util.List;

@Service
@Transactional
public class RewardsPunishmentServiceImpl implements RewardsPunishmentService {

    private final RewardsPunishmentMapper rewardsPunishmentMapper;

    @Autowired
    public RewardsPunishmentServiceImpl(RewardsPunishmentMapper rewardsPunishmentMapper){
        this.rewardsPunishmentMapper = rewardsPunishmentMapper;
    }

    @Override
    public List<RewardsPunishment> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage - 1) * lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return rewardsPunishmentMapper.findAllBySplit(currentPage, lineSize);
    }

    @Override
    public Integer getAllCount() {
        return rewardsPunishmentMapper.getAllCount();
    }

    @Override
    public boolean remove(Integer id) {
        return rewardsPunishmentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean register(RewardsPunishment rewardsPunishment) {
        return rewardsPunishmentMapper.insert(rewardsPunishment) > 0;
    }

    @Override
    public boolean update(RewardsPunishment rewardsPunishment) {
        return rewardsPunishmentMapper.updateByPrimaryKey(rewardsPunishment) > 0;
    }
}
