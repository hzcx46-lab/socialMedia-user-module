package com.huangzichun.socialmediausermoduleapplication.port.in.command;

public record UserRegisterCommand(
        String mobile,
        String rawPassword) {
}
