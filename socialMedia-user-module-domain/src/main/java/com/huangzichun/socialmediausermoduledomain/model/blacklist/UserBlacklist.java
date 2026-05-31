package com.huangzichun.socialmediausermoduledomain.model.blacklist;
import com.huangzichun.socialmediausermoduledomain.exception.DomainException;
import java.time.LocalDateTime;

public class UserBlacklist {
    private Long id;
    private Long userId;
    private Long targetUserId;
    private LocalDateTime createTime;
    //私有构造器，确保外部无法直接实例化，强制使用工厂方法
    private UserBlacklist() {}
    //静态static create(),工厂构造法(专门用来生产对象的静态方法)，提供单一入口点
    //static 防止  UserBlacklist userBlacklist = new UserBlacklist()
    public static UserBlacklist create(Long id, Long userId, Long targetUserId) {
        //进行业务校验
        if (userId == null || targetUserId == null) {
            throw new DomainException("用户ID或目标用户ID不能为空");
        }
        if (userId.equals(targetUserId)) {
            throw new DomainException("不能拉黑自己");
        }

        UserBlacklist blacklist = new UserBlacklist();
        blacklist.id = id;
        blacklist.userId = userId;
        blacklist.targetUserId = targetUserId;
        blacklist.createTime = LocalDateTime.now();
        return blacklist;
    }

    // Getters方法
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getTargetUserId() { return targetUserId; }
    public LocalDateTime getCreateTime() { return createTime; }
}

