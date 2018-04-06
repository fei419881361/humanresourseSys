package service.serviceImpl;

import dao.SalaryMapper;
import entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.SalaryService;

import java.util.List;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService{

    private final SalaryMapper salaryMapper;

    @Autowired
    public SalaryServiceImpl(SalaryMapper salaryMapper){
        this.salaryMapper = salaryMapper;
    }

    @Override
    public List<Salary> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage - 1) * lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return salaryMapper.findAllBySplit(currentPage, lineSize);
    }

    @Override
    public Integer getAllCount() {
        return salaryMapper.getAllCount();
    }

    @Override
    public boolean remove(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean register(Salary salary) {
        return salaryMapper.insert(salary) > 0;
    }

    @Override
    public boolean update(Salary salary) {
        return salaryMapper.updateByPrimaryKey(salary) > 0;
    }

    @Override
    public Salary find(Integer id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Salary> findByEId(Integer id) {
        return salaryMapper.findByEId(id);
    }
}
