package web;

import com.google.gson.Gson;
import entity.RewardsPunishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.RewardsPunishmentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rp")
public class RewardsPunishmentController {

    private final RewardsPunishmentService rewardsPunishmentService;

    @Autowired
    public RewardsPunishmentController(RewardsPunishmentService rewardsPunishmentService){
        this.rewardsPunishmentService = rewardsPunishmentService;
    }

    @RequestMapping("/findAllBySplit")
    @ResponseBody
    public String findAllBySplit(Integer page,Integer rows){
        List<RewardsPunishment> rewardsPunishmentList = rewardsPunishmentService.findAllBySplit(page,rows);
        System.out.println("rp size:"+rewardsPunishmentList.size());
        Integer num = rewardsPunishmentService.getAllCount();
        Map<String , Object> map = new HashMap<>();
        map.put("total",num);
        map.put("rows",rewardsPunishmentList);
        Gson gson = new Gson();
        String gs = gson.toJson(map);
        return gs;
    }

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String register(RewardsPunishment rewardsPunishment, HttpServletRequest httpServletRequest ){
        System.out.println("验证rp \n"+rewardsPunishment.toString());
        Map<String,Object> map = new HashMap<>();
        if(rewardsPunishment.getTheme() == null){
            map.put("message","添加奖惩信息失败，主题名称为空");
        }else {
            boolean b = rewardsPunishmentService.register(rewardsPunishment);
            System.out.println("rp register::"+b);
            map.put("message","添加奖惩信息成功！！");
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
            boolean b = rewardsPunishmentService.remove(ids[i]);
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
    public String updateInfo(RewardsPunishment rewardsPunishment){
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();


        if(rewardsPunishmentService.update(rewardsPunishment)){
            System.out.println("rp update success");
            map.put("message","修改信息成功！");
        }else {
            System.out.println("rp update fail");
            map.put("message","信息修改失败！！");
        }


        return gson.toJson(map);
    }

}
