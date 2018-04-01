package service;

import entity.AdminUser;

public interface AdminUserService {
    AdminUser AdminUserLogin(String loginName,String passwd);
}
