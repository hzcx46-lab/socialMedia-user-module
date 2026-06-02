package com.huangzichun.socialmediausermoduledomain.service;

import com.huangzichun.socialmediausermoduledomain.port.PasswordMatcher;
import com.huangzichun.socialmediausermoduledomain.port.UserRepository;

public class UserLoginDomainService {
    private final UserRepository userRepository;
    private final PasswordMatcher passwordMatcher;
}
