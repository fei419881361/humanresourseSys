package web;

import com.google.gson.Gson;
import entity.Employee;
import entity.SysDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepartmentService;
import service.EmployeeService;
import vo.EmployeeVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpoleeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmpoleeController(EmployeeService employeeService,DepartmentService departmentService){
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){

        List<Employee> employeeList = employeeService.findAllBySplit(page,rows);
        List<EmployeeVO> employeeVOS = new ArrayList<>();

        System.out.println("emp size:==>"+employeeList.size());
        for (int i = 0; i < employeeList.size(); i++) {
            SysDep dep = departmentService.findByID(employeeList.get(i).getDepId());
            if(dep != null){
                EmployeeVO employeeVO = new EmployeeVO(employeeList.get(i));
                employeeVO.setDepName(dep.getName());
                employeeVOS.add(employeeVO);
            }
        }

        Integer num = employeeService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",employeeVOS);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(EmployeeVO employeeVO, HttpServletRequest httpServletRequest ){
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        Employee employee = new Employee(employeeVO);
        SysDep sysDep = departmentService.selectByName(employeeVO.getDepName());
        if(sysDep == null){
            map.put("message","添加员工失败，部门名称错误");
            return gson.toJson(map);
        }

        employee.setDepId(sysDep.getId());
        System.out.println("验证emp::\n"+employee.toString());

        if (employeeService.register(employee)){
            map.put("message","添加员工成功！！");
            return gson.toJson(map);
        }
        map.put("message","添加员工失败！！");
        return gson.toJson(map);
    }

    @RequestMapping(value = "/remove",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String remove(Integer[] ids){
        String message = "";
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < ids.length ; i++) {
            boolean b = employeeService.remove(ids[i]);
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
    public String updateInfo(EmployeeVO employeeVO){
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        Employee employee = new Employee(employeeVO);
        SysDep sysDep = departmentService.selectByName(employeeVO.getDepName());
        if (sysDep == null){
            map.put("message","所修改的部门不存在！");
        }else {
            employee.setDepId(sysDep.getId());
        }

        if(employeeService.update(employee)){
            System.out.println("emp update success");
            map.put("message","修改信息成功！");
        }else {
            System.out.println("emp update fail");
            map.put("message","信息修改失败！！");
        }


        return gson.toJson(map);
    }

}
