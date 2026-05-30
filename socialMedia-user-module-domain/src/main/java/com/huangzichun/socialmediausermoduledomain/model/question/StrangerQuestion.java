package com.huangzichun.socialmediausermoduledomain.model.question;

import com.huangzichun.socialmediausermoduledomain.exception.DomainException;

import java.time.LocalDateTime;

public class StrangerQuestion {
    private Long id;
    private Long userId;
    private String question;
    private Integer sortOrder;
    private Integer status; // 0-禁用, 1-启用
    private LocalDateTime createTime;
     //私有构造器
    private StrangerQuestion() {}
    //工厂方法
    public static StrangerQuestion create(Long id, Long userId, String question, Integer sortOrder) {
        //业务逻辑校验
        if (question == null || question.trim().isEmpty()) {
            throw new DomainException("破冰问题不能为空");
        }
        if (question.length() > 50) {
            throw new DomainException("破冰问题不能超过50个字符");
        }

        StrangerQuestion sq = new StrangerQuestion();
        sq.id = id;
        sq.userId = userId;
        sq.question = question;
        sq.sortOrder = sortOrder != null ? sortOrder : 0;
        sq.status = 1;
        sq.createTime = LocalDateTime.now();
        return sq;
    }
}
