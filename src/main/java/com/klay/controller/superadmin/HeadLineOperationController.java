package com.klay.controller.superadmin;



import com.klay.entity.bo.HeadLine;
import com.klay.entity.dto.Result;
import com.klay.service.solo.HeadLineService;
import org.myspringframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
//@RequestMapping(value = "/headline")
public class HeadLineOperationController {
//    @Autowired(value = "HeadLineServiceImpl")
    private HeadLineService headLineService;
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addHeadLine(@RequestParam("lineName") String lineName,
//                                    @RequestParam("lineLink")String lineLink,
//                                    @RequestParam("lineImg")String lineImg,
//                                    @RequestParam("priority")Integer priority){
//        HeadLine headLine = new HeadLine();
//        headLine.setLineName(lineName);
//        headLine.setLineLink(lineLink);
//        headLine.setLineImg(lineImg);
//        headLine.setPriority(priority);
//        Result<Boolean> result = headLineService.addHeadLine(headLine);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setView("addheadline.jsp").addViewData("result", result);
//        return modelAndView;
//    }
//    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public void removeHeadLine(){
        System.out.println("删除HeadLine");
    }
//    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp){
//        //TODO:参数校验以及请求参数转化
//        return headLineService.modifyHeadLine(new HeadLine());
//    }
    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineById(1);
    }
//    @RequestMapping(value = "/query", method = RequestMethod.GET)
//    @ResponseBody
    public Result<List<HeadLine>>queryHeadLine(){
        return headLineService.queryHeadLine(null, 1, 100);
    }


}
