package web;

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
import java.util.List;

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


}
