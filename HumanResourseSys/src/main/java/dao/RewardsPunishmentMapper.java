package dao;

import entity.RewardsPunishment;
import entity.RewardsPunishmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RewardsPunishmentMapper {
    long countByExample(RewardsPunishmentExample example);

    int deleteByExample(RewardsPunishmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RewardsPunishment record);

    int insertSelective(RewardsPunishment record);

    List<RewardsPunishment> selectByExample(RewardsPunishmentExample example);

    RewardsPunishment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RewardsPunishment record, @Param("example") RewardsPunishmentExample example);

    int updateByExample(@Param("record") RewardsPunishment record, @Param("example") RewardsPunishmentExample example);

    int updateByPrimaryKeySelective(RewardsPunishment record);

    int updateByPrimaryKey(RewardsPunishment record);

    Integer getAllCount();

    List<RewardsPunishment> findAllBySplit(@Param("currentPage") Integer currentPage,@Param("lineSize") Integer lineSize);
}