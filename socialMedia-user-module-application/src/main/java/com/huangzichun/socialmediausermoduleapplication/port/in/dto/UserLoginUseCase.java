package com.huangzichun.socialmediausermoduleapplication.port.in.dto;

import com.huangzichun.socialmediausermoduleapplication.port.in.command.UserLoginCommand;

public interface UserLoginUseCase {
    UserLoginResultDTO login(UserLoginCommand command);
}
