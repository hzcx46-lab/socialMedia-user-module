package com.huangzichun.socialmediausermoduledomain.model;

import com.huangzichun.socialmediausermoduledomain.event.DomainEvent;
import com.huangzichun.socialmediausermoduledomain.exception.DomainException;

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

    /**
     * 工厂方法：从持久化层还原聚合根（不触发领域事件）
     */
    public static User restore(Long id,
                               String mobile,
                               Password encryptedPassword,
                               Integer status,
                               Integer version,
                               Integer deleted,
                               String hxUser,
                               String hxPassword) {
        if (id == null || id <= 0) {
            throw new DomainException("用户ID必须有效");
        }
        if (mobile == null || mobile.trim().length() != 11) {
            throw new DomainException("手机号格式不正确");
        }
        if (encryptedPassword == null) {
            throw new DomainException("密码不能为空");
        }

        User user = new User();
        user.id = id;
        user.mobile = mobile;
        user.password = encryptedPassword;
        user.status = status;
        user.version = version;
        user.deleted = deleted;
        user.hxUser = hxUser;
        user.hxPassword = hxPassword;

        return user; }
}
