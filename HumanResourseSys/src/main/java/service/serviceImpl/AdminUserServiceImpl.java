package service.serviceImpl;

import dao.AdminUserMapper;
import entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AdminUserService;

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
}
