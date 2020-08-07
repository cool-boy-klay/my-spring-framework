package com.klay.service.solo;

import com.klay.entity.bo.HeadLine;
import com.klay.entity.dto.Result;

import java.util.List;

public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(int headLineId);
    Result<Boolean> modifyHeadLine(int headLineId);

    Result<HeadLine> queryHeadLineById(int headLineId);
    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition,int pageIndex,int pageSize);
}
