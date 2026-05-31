package com.huangzichun.socialmediausermoduledomain.model;
import com.huangzichun.socialmediausermoduledomain.event.DomainEvent;
import com.huangzichun.socialmediausermoduledomain.event.UserRegisteredEvent;
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
    private UserProfile profile;
    private UserSetting setting;
    // 领域事件容器
    private final List<DomainEvent> domainEvents = new ArrayList<>();
    // 禁用默认无参构造（外部禁止直接 new），例如，new User()
    private User() {}
    /**
     * 工厂方法：从持久化层还原聚合根（不触发领域事件）
     */
    //User对象的静态工厂方法，从持久化层调出数据，重新组装成领域对象，
    public static User restore(Long id,
                               String mobile,
                               Password encryptedPassword,
                               Integer status,
                               Integer version,
                               Integer deleted,
                               String hxUser,
                               String hxPassword) {
        //业务校验
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
    /**
     * 工厂方法：用户注册 static
     */
    public static User register(Long id, String mobile, Password encryptedPassword) {

        if (mobile == null || mobile.trim().length() != 11) { // 简单校验
            throw new DomainException("手机号格式不正确");
        }
        if (encryptedPassword == null) {
            throw new DomainException("密码不能为空");
        }
        User user = new User();
        user.id = id;
        user.mobile = mobile;
        user.password = encryptedPassword;
        user.status = 1; // 默认正常
        user.version = 0;
        user.deleted = 0;
        // 同步初始化关联实体，保持强一致性生命周期
        user.profile= new UserProfile(id);
        user.setting = new UserSetting(id);
        // 发布领域事件
        user.domainEvents.add(new UserRegisteredEvent(id, mobile));
        return user;
    }
    /**
     * 更新用户资料
     */
    public void updateProfile(String nickname, Integer gender, java.time.LocalDate birthday, String city, String avatar, String income, String profession, Integer marriage, String coverPic, java.util.Map<String, Object> tags) {
        if (this.status == 0) {
            throw new DomainException("账号已被禁用，无法修改资料");
        }
        if (this.profile == null) {
            this.profile = new UserProfile(this.id);
        }
        this.profile.updateBaseInfo(nickname, gender, birthday, city, avatar, income, profession, marriage, coverPic, tags);
    }
    /**
     * 更新偏好设置
     */
    public void updateSetting(Integer likeNotification, Integer commentNotification, Integer systemNotification) {
        if (this.status == 0) {
            throw new DomainException("账号已被禁用，无法修改设置");
        }
        if (this.setting == null) {
            this.setting = new UserSetting(this.id);
        }
        this.setting.updateNotification(likeNotification, commentNotification, systemNotification);
    }

    public void enable() {
        this.status = 1;
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }

    // Getters
    public Long getId() { return id; }
    public String getMobile() { return mobile; }
    public Password getPassword() { return password; }
    public String getHxUser() { return hxUser; }
    public String getHxPassword() { return hxPassword; }
    public Integer getStatus() { return status; }
    public Integer getVersion() { return version; }
    public Integer getDeleted() { return deleted; }
    public UserProfile getProfile() { return profile; }
    public UserSetting getSetting() { return setting; }
    public List<DomainEvent> getDomainEvents() { return domainEvents; }
}
