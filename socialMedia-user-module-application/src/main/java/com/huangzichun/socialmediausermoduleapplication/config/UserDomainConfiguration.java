package com.huangzichun.socialmediausermoduleapplication.config;

import org.springframework.context.annotation.Bean;

public class UserDomainConfiguration {
    @Bean
    public UserLoginDomainService userLoginDomainService(UserRepository userRepository,
                                                         PasswordMatcher passwordMatcher) {
        return new UserLoginDomainService(userRepository, passwordMatcher);
    }
}
