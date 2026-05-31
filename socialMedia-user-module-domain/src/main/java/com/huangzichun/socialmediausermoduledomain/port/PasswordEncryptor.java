package com.huangzichun.socialmediausermoduledomain.port;

import com.huangzichun.socialmediausermoduledomain.model.Password;
@FunctionalInterface
//声明函数式接口，并且函数式接口只能有一个抽象方法
public interface PasswordEncryptor {
    Password encrypt(String rawPassword);
}
