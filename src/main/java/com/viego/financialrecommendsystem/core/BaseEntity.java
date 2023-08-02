package com.viego.financialrecommendsystem.core;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * @author viego
 * @date 2023/7/25 16:18
 */
@Data
public class BaseEntity {
    /*创建者*/
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    /*创建日期*/
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /*更新者*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    /*更新日期*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
