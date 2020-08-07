package com.klay.controller.frontend;


import com.klay.entity.dto.MainPageInfoDTO;
import com.klay.entity.dto.Result;
import com.klay.service.combine.HeadLineShopCategoryCombineService;
import lombok.Getter;
import org.myspringframework.core.annotation.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Getter
//@RequestMapping(value = "/main")
public class MainPageController {
//    @Autowired(value = "HeadLineShopCategoryCombineServiceImpl")
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void throwException(){
        throw new RuntimeException("抛出异常测试");
    }
}
