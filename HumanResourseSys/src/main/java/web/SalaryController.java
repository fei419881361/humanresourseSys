package web;

import com.google.gson.Gson;
import entity.Employee;
import entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.EmployeeService;
import service.SalaryService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sal")
public class SalaryController {
    private final SalaryService salaryService;
    private final EmployeeService employeeService;

    @Autowired
    public SalaryController(SalaryService salaryService,EmployeeService employeeService){
        this.salaryService = salaryService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){
        List<Salary> salaryList = salaryService.findAllBySplit(page,rows);

        System.out.println("sal size:"+salaryList.size());
        Integer num = salaryService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",salaryList);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(Salary salary){
        System.out.println("验证sal \n"+salary.toString());
        Map<String,Object> map = new HashMap<>();
        Employee employee = employeeService.findByID(salary.getEmpId());
        if(employee == null){
            map.put("message","无该员工信息！");
            return new Gson().toJson(map);
        }

        if(salary == null ){
            map.put("message","添加部门失败");
        }else {
            boolean b = salaryService.register(salary);
            System.out.println("sal register::"+b);
            map.put("message","添加薪资信息成功！！");
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
            boolean b = salaryService.remove(ids[i]);
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

    @RequestMapping(value = "/update",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String updateInfo(Salary salary){
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();

        if(salaryService.update(salary)){
            System.out.println("sal update success");
            map.put("message","修改信息成功！");
        }else {
            System.out.println("rec update fail");
            map.put("message","信息修改失败！！");
        }

        return gson.toJson(map);
    }

    @RequestMapping(value = "/find",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String find(Integer iid , String ename){
        Map<String,Object> map = new HashMap<>();
        List<Salary> salaryList = new ArrayList<>();
        if(iid!=null){
            System.out.println("salar iid"+iid);
            Salary salary = salaryService.find(iid);
            salaryList.add(salary);
        }
        else if(ename!=null){
            Employee employee = employeeService.findByName(ename);
            System.out.println("salar emp -->"+employee.getId());
            if (employee != null) {
                List<Salary> salaries = salaryService.findByEId(employee.getId());
                System.out.println("salar size -->"+salaries.size());
                if(salaries != null){
                    for (int i = 0; i < salaries.size(); i++) {
                        salaryList.add(salaries.get(i));
                    }
                }
            }
        }
        map.put("total",salaryList.size());
        map.put("rows",salaryList);
        map.put("message","搜索完毕");
        return new Gson().toJson(map);
    }

}
