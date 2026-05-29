package com.huangzichun.socialmediausermoduleapplication.port.in.command;

public record UserLoginCommand(
        String mobile,
        String rawPassword) {
}
