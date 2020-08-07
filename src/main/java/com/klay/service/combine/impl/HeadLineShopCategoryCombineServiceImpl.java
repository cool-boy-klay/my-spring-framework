package com.klay.service.combine.impl;

import com.klay.entity.bo.HeadLine;
import com.klay.entity.bo.ShopCategory;
import com.klay.entity.dto.MainPageInfoDTO;
import com.klay.entity.dto.Result;
import com.klay.service.combine.HeadLineShopCategoryCombineService;
import com.klay.service.solo.HeadLineService;
import com.klay.service.solo.ShopCategoryService;
import org.myspringframework.core.annotation.Service;

import java.util.List;

@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    private HeadLineService headLineService;
    private ShopCategoryService shopCategoryService;


    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult  = headLineService.queryHeadLine(headLineCondition,1,4);
        //2.获取店铺类别列表
        ShopCategory shopCategory = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult  =shopCategoryService.queryShopCategory(shopCategory,1,100);
        //3.合并两者返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult,shopCategoryResult);
        return result;

    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult,Result<List<ShopCategory>> shopCategoryResult){
        return null;
    }
}
