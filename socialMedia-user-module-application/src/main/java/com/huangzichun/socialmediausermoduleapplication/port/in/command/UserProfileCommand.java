package com.huangzichun.socialmediausermoduleapplication.port.in.command;

import java.time.LocalDate;
import java.util.Map;

public record UserProfileCommand(
        Long id,
        String nickname,
        String avatar,
        Integer gender,
        LocalDate birthday,
        String income,
        String profession,
        Integer marriage,
        String coverPic,
        Map<String, Object> tags) {
}
