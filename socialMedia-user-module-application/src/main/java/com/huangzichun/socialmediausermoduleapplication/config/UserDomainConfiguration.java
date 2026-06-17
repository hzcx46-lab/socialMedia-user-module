package com.huangzichun.socialmediausermoduleapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDomainConfiguration {
    @Bean
    public UserLoginDomainService userLoginDomainService(
            UserRepository userRepository,
            PasswordMatcher passwordMatcher) {
        return new UserLoginDomainService(userRepository, passwordMatcher);
    }
    @Bean
    public UserRegisterDomainService userRegisterDomainService(UserRepository userRepository,
                                                               IdGenerator idGenerator,
                                                               PasswordEncryptor passwordEncryptor) {
        return new UserRegisterDomainService(userRepository, idGenerator, passwordEncryptor);
    }
}
