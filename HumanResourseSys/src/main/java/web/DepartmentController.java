package web;

import com.google.gson.Gson;
import entity.SysDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepartmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dep")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService  departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){
        List<SysDep> deps = departmentService.findAllBySplit(page,rows);
        System.out.println(deps.size());
        Integer num = departmentService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",deps);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        System.out.println(deps.get(0).getCreateDate());
        return gs;
    }

}
