package service.serviceImpl;

import dao.SysDepMapper;
import entity.SysDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.DepartmentService;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    private final SysDepMapper sysDepMapper;

    @Autowired
    public DepartmentServiceImpl(SysDepMapper sysDepMapper){
        this.sysDepMapper = sysDepMapper;
    }

    @Override
    public List<SysDep> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage-1)*lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return sysDepMapper.findAllBySplit(currentPage,lineSize);
    }

    @Override
    public Integer getAllCount() {
        return sysDepMapper.getAllCount();
    }

    @Override
    public boolean register(SysDep dep) {
        return sysDepMapper.insert(dep)>0;
    }

    @Override
    public boolean remove(Integer id) {
        return sysDepMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public SysDep findByID(Integer depId) {
        return sysDepMapper.selectByPrimaryKey(depId);
    }

    @Override
    public SysDep selectByName(String name) {
        return sysDepMapper.selectByName(name);
    }
}
