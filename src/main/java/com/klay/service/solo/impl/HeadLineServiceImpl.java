package com.klay.service.solo.impl;

import com.klay.entity.bo.HeadLine;
import com.klay.entity.dto.Result;
import com.klay.service.solo.HeadLineService;
import org.myspringframework.core.annotation.Service;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
