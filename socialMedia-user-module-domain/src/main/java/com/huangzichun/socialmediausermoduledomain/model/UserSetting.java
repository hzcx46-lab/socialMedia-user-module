package com.huangzichun.socialmediausermoduledomain.model;

public class UserSetting {
    private Long id;
    private Integer likeNotification; // 0-关闭, 1-开启
    private Integer commentNotification;
    private Integer systemNotification;

    public UserSetting(Long id) {
        this.id = id;
        this.likeNotification = 1;
        this.commentNotification = 1;
        this.systemNotification = 1;
    }
}
