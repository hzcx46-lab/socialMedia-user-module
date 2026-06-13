package com.huangzichun.socialmediausermoduledomain.service;

import com.huangzichun.socialmediausermoduledomain.exception.DomainException;
import com.huangzichun.socialmediausermoduledomain.model.Password;
import com.huangzichun.socialmediausermoduledomain.model.User;
import com.huangzichun.socialmediausermoduledomain.port.IdGenerator;
import com.huangzichun.socialmediausermoduledomain.port.PasswordEncryptor;
import com.huangzichun.socialmediausermoduledomain.port.UserRepository;

public class UserRegisterDomainService {
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
        public User register(String mobile, String rawPassword){
            if (userRepository.existsByMobile(mobile)) {
                throw new DomainException("手机号已注册");
            }
            if (rawPassword == null || rawPassword.trim().isEmpty()) {
                throw new DomainException("密码不能为空");
            }
            Long id = idGenerator.nextId();
            Password encryptedPassword = passwordEncryptor.encrypt(rawPassword);
            User user = User.register(id, mobile, encryptedPassword);
            userRepository.save(user);

            user.getDomainEvents().forEach(event -> {
                // TODO: 发布领域事件到消息队列
            });
            user.clearDomainEvents();

            return user;
        }
}
