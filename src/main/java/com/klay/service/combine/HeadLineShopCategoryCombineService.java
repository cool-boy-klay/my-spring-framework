package com.klay.service.combine;

import com.klay.entity.dto.MainPageInfoDTO;
import com.klay.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
