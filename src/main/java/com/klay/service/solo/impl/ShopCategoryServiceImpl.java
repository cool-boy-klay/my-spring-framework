package com.klay.service.solo.impl;

import com.klay.entity.bo.HeadLine;
import com.klay.entity.bo.ShopCategory;
import com.klay.entity.dto.Result;
import com.klay.service.solo.ShopCategoryService;
import org.myspringframework.core.annotation.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(int headLineId) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int headLineId) {
        return null;
    }


    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategory, int pageIndex, int pageSize) {
        return null;
    }


}
