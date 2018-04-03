package dao;

import entity.SysDep;
import entity.SysDepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDepMapper {
    long countByExample(SysDepExample example);

    int deleteByExample(SysDepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDep record);

    int insertSelective(SysDep record);

    List<SysDep> selectByExample(SysDepExample example);

    SysDep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDep record, @Param("example") SysDepExample example);

    int updateByExample(@Param("record") SysDep record, @Param("example") SysDepExample example);

    int updateByPrimaryKeySelective(SysDep record);

    int updateByPrimaryKey(SysDep record);

    List<SysDep> findAllBySplit(@Param("currentPage") Integer currentPage, @Param("lineSize") Integer lineSize);

    Integer getAllCount();

    SysDep selectByName(String name);
}