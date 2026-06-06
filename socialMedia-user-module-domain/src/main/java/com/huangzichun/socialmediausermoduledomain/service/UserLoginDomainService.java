package com.huangzichun.socialmediausermoduledomain.service;

import com.huangzichun.socialmediausermoduledomain.enums.ResponseCodeEnum;
import com.huangzichun.socialmediausermoduledomain.exception.DomainException;
import com.huangzichun.socialmediausermoduledomain.model.User;
import com.huangzichun.socialmediausermoduledomain.port.PasswordMatcher;
import com.huangzichun.socialmediausermoduledomain.port.UserRepository;

public class UserLoginDomainService {
    private final UserRepository userRepository;
    private final PasswordMatcher passwordMatcher;
    public UserLoginDomainService(UserRepository userRepository, PasswordMatcher passwordMatcher) {
        this.userRepository = userRepository;
        this.passwordMatcher = passwordMatcher;
    }
    //参数校验，拦截无效密码
    public User loginByMobile(String mobile, String rawPassword) {
        //是否为空
        if (rawPassword == null || rawPassword.trim().isEmpty()) {
            //抛出异常，携带错误码，领域层异常
            throw new DomainException(ResponseCodeEnum.USERNAME_OR_PWD_ERROR);
        }
        //调用仓库层的方法去数据库通过手机号查找对象，user是optional<user>容器
        User user = userRepository.findByMobile(mobile)
                //如果没有值，通过lambda实现懒加载抛出用户不存在异常
                .orElseThrow(() -> new DomainException(ResponseCodeEnum.USER_DOES_NOT_EXIST));
        if (user.getDeleted() != null && user.getDeleted() == 1) {
            throw new DomainException("用户已删除");
        }
        if (user.getStatus() != null && user.getStatus() == 0) {
            throw new DomainException("账号已被禁用");
        }
        if (!passwordMatcher.matches(rawPassword, user.getPassword())) {
            throw new DomainException(ResponseCodeEnum.USERNAME_OR_PWD_ERROR);
        }
        return user;
    }

}
