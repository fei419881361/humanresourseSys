package service.serviceImpl;

import dao.AdminUserMapper;
import entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AdminUserService;

import java.util.List;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserMapper adminUserMapper;

    @Autowired
    public AdminUserServiceImpl(AdminUserMapper adminUserMapper){
        this.adminUserMapper = adminUserMapper;
    }

    @Override
    public AdminUser AdminUserLogin(String loginName, String passwd) {

        AdminUser adminUser = adminUserMapper.selectByLoginNameAndPasswd(loginName,passwd);
        return adminUser;
    }

    @Override
    public List<AdminUser> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage - 1) * lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return adminUserMapper.findAllBySplit(currentPage, lineSize);
    }

    @Override
    public Integer getAllCount() {
        return adminUserMapper.getAllCount();
    }

    @Override
    public boolean remove(Integer id) {
        return adminUserMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean register(AdminUser adminUser) {
        return adminUserMapper.insert(adminUser) > 0;
    }

    @Override
    public boolean update(AdminUser adminUser) {
        return adminUserMapper.updateByPrimaryKey(adminUser) > 0;
    }
}
