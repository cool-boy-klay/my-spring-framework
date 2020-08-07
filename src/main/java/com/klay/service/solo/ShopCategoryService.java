package com.klay.service.solo;

import com.klay.entity.bo.HeadLine;
import com.klay.entity.bo.ShopCategory;
import com.klay.entity.dto.Result;

import java.util.List;

public interface ShopCategoryService {
    Result<Boolean> addShopCategory(HeadLine headLine);
    Result<Boolean> removeShopCategory(int headLineId);
    Result<Boolean> modifyShopCategory(int headLineId);

    Result<ShopCategory> queryShopCategoryById(int headLineId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategory, int pageIndex, int pageSize);
}
