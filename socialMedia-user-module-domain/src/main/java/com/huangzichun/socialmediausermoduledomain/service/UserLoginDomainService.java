package com.huangzichun.socialmediausermoduledomain.service;

import com.huangzichun.socialmediausermoduledomain.port.PasswordMatcher;
import com.huangzichun.socialmediausermoduledomain.port.UserRepository;

public class UserLoginDomainService {
    private final UserRepository userRepository;
    private final PasswordMatcher passwordMatcher;
    public UserLoginDomainService(UserRepository userRepository, PasswordMatcher passwordMatcher) {
        this.userRepository = userRepository;
        this.passwordMatcher = passwordMatcher;
    }

}
