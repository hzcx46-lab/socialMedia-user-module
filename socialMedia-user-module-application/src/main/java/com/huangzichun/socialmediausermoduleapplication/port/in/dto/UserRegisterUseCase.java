package com.huangzichun.socialmediausermoduleapplication.port.in.dto;

import com.huangzichun.socialmediausermoduleapplication.port.in.command.UserRegisterCommand;

public interface UserRegisterUseCase {
    void register(UserRegisterCommand registerCommand);
}
