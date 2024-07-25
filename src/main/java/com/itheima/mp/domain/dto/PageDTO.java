package com.itheima.mp.domain.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@ApiModel(description = "分页结果实体")
public class PageDTO<T> {
    @ApiModelProperty("总条数")
    private Long total;
    @ApiModelProperty("总页数")
    private Long pages;
    @ApiModelProperty("集合")
    private List<T> list;

    public static <PO, VO> PageDTO<VO> of(Page<PO> p, Class<VO> clazz) {
        //1.封装vo结果
        PageDTO<VO> dto = new PageDTO<>();
        //1.1总条数
        dto.setTotal(p.getTotal());
        //1.2总页数
        dto.setPages(p.getPages());
        //1.3当前页数据
        List<PO> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            //设置一个空集合
            dto.setList(Collections.emptyList());
            return dto;
        }
        //1.4拷贝User的Vo
        dto.setList(BeanUtil.copyToList(records,clazz));
        //2.返回
        return dto;
    }
}
