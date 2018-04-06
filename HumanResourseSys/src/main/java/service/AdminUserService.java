package service;

import entity.AdminUser;

import java.util.List;

public interface AdminUserService {
    AdminUser AdminUserLogin(String loginName,String passwd);

    List<AdminUser> findAllBySplit(Integer currentPage , Integer lineSize);

    Integer getAllCount();

    boolean remove(Integer id);

    boolean register(AdminUser adminUser);

    boolean update(AdminUser adminUser);
}
