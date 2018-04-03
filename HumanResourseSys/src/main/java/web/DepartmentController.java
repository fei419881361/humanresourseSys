package web;

import com.google.gson.Gson;
import entity.SysDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepartmentService;
import service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dep")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @Autowired
    public DepartmentController(DepartmentService  departmentService,EmployeeService employeeService){
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){
        List<SysDep> deps = departmentService.findAllBySplit(page,rows);
        for (int i = 0; i < deps.size(); i++) {
            int pnum = employeeService.selectByDepName(deps.get(i).getId());
            deps.get(i).setPeopleNum(pnum);
        }
        System.out.println(deps.size());
        Integer num = departmentService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",deps);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(SysDep dep, HttpServletRequest httpServletRequest ){
        dep.setPeopleNum(0);
        dep.setCreateDate(new Date());
        dep.setOperatorId((Integer) (httpServletRequest.getSession().getAttribute("id")));
        dep.setModifyDate(new Date());
        System.out.println("验证dep \n"+dep.toString());
        Map<String,Object> map = new HashMap<>();
        if(dep.getName() == null || dep.equals("")){
            map.put("message","添加部门失败，部门名称为空");
        }else {
            boolean b = departmentService.register(dep);
            System.out.println("register::"+b);
            map.put("message","添加部门成功！！");
        }
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        System.out.println(gs);
        return gs;
    }

    @RequestMapping(value = "/remove",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String remove(Integer[] ids){
        String message = "";
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < ids.length ; i++) {
            boolean b = departmentService.remove(ids[i]);
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

}
