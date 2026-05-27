package com.huangzichun.socialmediausermoduleapplication.port.command;

public record UserLoginCommand(
        String mobile,
        String rawPassword) {
}
