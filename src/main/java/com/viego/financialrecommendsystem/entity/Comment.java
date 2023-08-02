package com.viego.financialrecommendsystem.entity;

import com.viego.financialrecommendsystem.core.BaseEntity;
import lombok.Data;

@Data
public class Comment  extends BaseEntity {
    private Long CommentId;
    private Long userId;
    private Long discussId;
    private String content;
    private String img;
}
