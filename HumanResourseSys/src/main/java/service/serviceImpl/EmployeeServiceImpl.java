package service.serviceImpl;

import dao.EmployeeMapper;
import entity.Employee;
import entity.SysDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.EmployeeService;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage-1)*lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return employeeMapper.findAllBySplit(currentPage,lineSize);
    }

    @Override
    public Integer getAllCount() {
        return employeeMapper.getAllCount();
    }

    @Override
    public boolean remove(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean register(Employee employee) {
        return employeeMapper.insert(employee)>0;
    }

    @Override
    public boolean update(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee)>0;
    }

    @Override
    public int selectByDepName(Integer depId) {
        return employeeMapper.selectByDepName(depId);
    }

    @Override
    public Employee findByID(Integer integer) {
        return employeeMapper.selectByPrimaryKey(integer);
    }

    @Override
    public Employee selectById(Integer integer) {
        return employeeMapper.selectByPrimaryKey(integer);
    }
}
