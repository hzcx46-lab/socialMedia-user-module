package com.huangzichun.socialmediausermoduleapplication.port.command;

public record UserRegisterCommand(
        String mobile,
        String rawPassword) {
}
