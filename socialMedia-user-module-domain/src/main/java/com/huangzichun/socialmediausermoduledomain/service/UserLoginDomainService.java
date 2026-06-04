package com.huangzichun.socialmediausermoduledomain.service;

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
    public User loginByMobile(String mobile, String rawPassword) {
        if (rawPassword == null || rawPassword.trim().isEmpty()) {
            throw new DomainException(ResponseCodeEnum.USERNAME_OR_PWD_ERROR);
        }

}
