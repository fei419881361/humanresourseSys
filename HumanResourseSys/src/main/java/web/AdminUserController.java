package web;

import com.google.gson.Gson;
import entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AdminUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/admin/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){

        List<AdminUser> adminUserList= adminUserService.findAllBySplit(page,rows);

        System.out.println("admin size:==>"+adminUserList.size());
        System.out.println(adminUserList.get(0).toString());

        Integer num = adminUserService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",adminUserList);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/admin/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(AdminUser adminUser){
        System.out.println("admin register:\n"+adminUser.toString());
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();


        if (adminUserService.register(adminUser)){
            map.put("message","添加信息成功！！");
            return gson.toJson(map);
        }
        map.put("message","添加信息失败！！");
        return gson.toJson(map);
    }

    @RequestMapping(value = "/admin/remove",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String remove(Integer[] ids){
        String message = "";
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < ids.length ; i++) {
            boolean b = adminUserService.remove(ids[i]);
            if(b){
                message = "删除成功";

            }else {
                message = "删除失败";
                System.out.println("删除失败");
            }
        }
        map.put("message",message);
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/admin/update",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String updateInfo(AdminUser adminUser){
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();

        if(adminUserService.update(adminUser)){
            System.out.println("admin update success");
            map.put("message","修改信息成功！");
        }else {
            System.out.println("admin update fail");
            map.put("message","信息修改失败！！");
        }

        return gson.toJson(map);
    }
}
