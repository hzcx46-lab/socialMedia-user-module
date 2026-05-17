package com.huangzichun.socialmediausermoduledomain.model;

import com.huangzichun.socialmediausermoduledomain.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String mobile;
    private Password password;
    private String hxUser;
    private String hxPassword;
    private Integer status; // 0-禁用, 1-正常
    private Integer version;
    private Integer deleted;// 0-未删除, 1-已删除
    //聚灵根内部维护实体
    private UserProfile userProfile;
    private UserSetting userSetting;
    // 领域事件容器
    private final List<DomainEvent> domainEvents = new ArrayList<>();
}
