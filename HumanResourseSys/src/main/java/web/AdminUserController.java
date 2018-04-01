package web;

import entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AdminUserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminUserController {
    private final AdminUserService adminUserService;

    @Autowired
    public AdminUserController(AdminUserService adminUserService){
        this.adminUserService = adminUserService;
    }

    @RequestMapping("/login")
    public String Login(String loginName,String password,HttpServletRequest httpServletRequest){
        AdminUser adminUser = adminUserService.AdminUserLogin(loginName,password);
        if(adminUser==null){
            return "error";
        }else {
            String adminUserName = adminUser.getName();
            httpServletRequest.setAttribute("aname",adminUserName);
            httpServletRequest.getSession().setAttribute("id",adminUser.getId());
        }
        return "index2";
    }
}
