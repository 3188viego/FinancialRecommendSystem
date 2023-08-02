package com.viego.financialrecommendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viego.financialrecommendsystem.entity.AccessRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessRecordMapper extends BaseMapper<AccessRecord> {

    int insertList(List<AccessRecord> list);
}
