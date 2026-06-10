package com.huangzichun.socialmediausermoduledomain.service;

import com.huangzichun.socialmediausermoduledomain.port.IdGenerator;
import com.huangzichun.socialmediausermoduledomain.port.PasswordEncryptor;
import com.huangzichun.socialmediausermoduledomain.port.UserRepository;

public class UserRegisterDomain {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;
    private final PasswordEncryptor passwordEncryptor;
    public UserRegisterDomainService(UserRepository userRepository,
                                     IdGenerator idGenerator,
                                     PasswordEncryptor passwordEncryptor) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.passwordEncryptor = passwordEncryptor;
    }

}
