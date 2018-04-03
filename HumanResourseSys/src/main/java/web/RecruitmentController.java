package web;

import com.google.gson.Gson;
import entity.Recruitment;
import entity.SysDep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepartmentService;
import service.RecruitmentService;
import vo.RecruitmentVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rec")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;
    private final DepartmentService departmentService;

    @Autowired
    public RecruitmentController(RecruitmentService recruitmentService,DepartmentService departmentService){
        this.recruitmentService = recruitmentService;
        this.departmentService = departmentService;
    }


    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){

        List<Recruitment> recruitmentList = recruitmentService.findAllBySplit(page,rows);
        List<RecruitmentVO> recruitmentVOS = new ArrayList<>();

        System.out.println("rec size:==>"+recruitmentList.size());
        for (int i = 0; i < recruitmentList.size(); i++) {
            SysDep dep = departmentService.findByID(recruitmentList.get(i).getDepId());
            if(dep != null){
                RecruitmentVO recruitmentVO = new RecruitmentVO(recruitmentList.get(i));
                recruitmentVO.setDepName(dep.getName());
                recruitmentVOS.add(recruitmentVO);
            }
        }

        Integer num = recruitmentService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",recruitmentVOS);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(RecruitmentVO recruitmentVO){
        System.out.println("rec register:\n"+recruitmentVO.toString());
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        Recruitment recruitment = new Recruitment(recruitmentVO);
        SysDep sysDep = departmentService.selectByName(recruitmentVO.getDepName());
        if(sysDep == null){
            map.put("message","添加招聘失败，应聘部门名称错误");
            return gson.toJson(map);
        }

        recruitment.setDepId(sysDep.getId());
        System.out.println("rec::\n"+recruitment.toString());

        if (recruitmentService.register(recruitment)){
            map.put("message","添加招聘信息成功！！");
            return gson.toJson(map);
        }
        map.put("message","添加招聘信息失败！！");
        return gson.toJson(map);
    }

    @RequestMapping(value = "/remove",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String remove(Integer[] ids){
        String message = "";
        Gson gson = new Gson();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < ids.length ; i++) {
            boolean b = recruitmentService.remove(ids[i]);
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
    public String updateInfo(RecruitmentVO recruitmentVO){
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        Recruitment recruitment = new Recruitment(recruitmentVO);
        SysDep sysDep = departmentService.selectByName(recruitmentVO.getDepName());
        if (sysDep == null){
            map.put("message","所修改的部门不存在！");
        }else {
            recruitment.setDepId(sysDep.getId());
        }

        if(recruitmentService.update(recruitment)){
            System.out.println("rec update success");
            map.put("message","修改信息成功！");
        }else {
            System.out.println("rec update fail");
            map.put("message","信息修改失败！！");
        }


        return gson.toJson(map);
    }



}
