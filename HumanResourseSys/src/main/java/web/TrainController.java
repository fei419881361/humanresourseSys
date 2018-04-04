package web;

import com.google.gson.Gson;
import entity.Employee;
import entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.EmployeeService;
import service.TrainService;
import vo.TrainVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tra")
public class TrainController {
    private final TrainService trainService;
    private final EmployeeService employeeService;

    @Autowired
    public TrainController(TrainService trainService, EmployeeService employeeService){
        this.trainService = trainService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){

        List<Train> trainList= trainService.findAllBySplit(page,rows);
        List<TrainVO> trainVOS= new ArrayList<>();

        System.out.println("tra size:==>"+trainList.size());
        for (int i = 0; i < trainList.size(); i++) {
            Employee employee = employeeService.findByID(trainList.get(i).getEId());
            if(employee != null){
                TrainVO trainVO= new TrainVO(trainList.get(i));
                trainVO.setTrainEmp(employee.getName());
                trainVOS.add(trainVO);
            }
        }

        Integer num = trainService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",trainVOS);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(TrainVO trainVO){
        System.out.println("tra register:\n"+trainVO.toString());
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        Train train = new Train(trainVO);
        Employee employee= employeeService.selectById(trainVO.geteId());
        if(employee == null){
            map.put("message","添加失败，培训员工未找到");
            return gson.toJson(map);
        }

        train.setEId(employee.getId());
        System.out.println("tra::\n"+train.toString());

        if (trainService.register(train)){
            map.put("message","添加培训信息成功！！");
            return gson.toJson(map);
        }
        map.put("message","添加培训信息失败！！");
        return gson.toJson(map);
    }

    @RequestMapping(value = "/remove",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String remove(Integer[] ids){
        String message = "";
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < ids.length ; i++) {
            boolean b = trainService.remove(ids[i]);
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
    public String updateInfo(TrainVO trainVO){
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        Train train = new Train(trainVO);
        Employee employee = employeeService.selectById(trainVO.geteId());
        if (employee == null){
            map.put("message","所修改的员工不存在！");
        }else {
            train.setEId(employee.getId());
        }

        if(trainService.update(train)){
            System.out.println("tra update success");
            map.put("message","修改信息成功！");
        }else {
            System.out.println("rec update fail");
            map.put("message","信息修改失败！！");
        }


        return gson.toJson(map);
    }

}
