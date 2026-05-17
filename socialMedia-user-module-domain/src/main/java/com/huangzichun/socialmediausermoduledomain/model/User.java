package com.huangzichun.socialmediausermoduledomain.model;

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
}
