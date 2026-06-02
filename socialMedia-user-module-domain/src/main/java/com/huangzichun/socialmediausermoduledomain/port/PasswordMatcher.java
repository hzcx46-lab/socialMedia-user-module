package com.huangzichun.socialmediausermoduledomain.port;
import com.huangzichun.socialmediausermoduledomain.model.Password;
@FunctionalInterface
public interface PasswordMatcher {
    boolean matches(String rawPassword, Password encryptedPassword);
}
