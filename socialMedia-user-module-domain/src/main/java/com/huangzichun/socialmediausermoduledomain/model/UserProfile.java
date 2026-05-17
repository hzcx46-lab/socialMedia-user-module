package com.huangzichun.socialmediausermoduledomain.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    private Long id;
    private String nickname;
    private String avatar;
    private Integer gender; // 0-未知, 1-男, 2-女
    private LocalDate birthday;
    private String city;
    private String income;
    private String profession;
    private Integer marriage; // 0-未婚, 1-离异, 2-丧偶
    private String coverPic;
    private Map<String, Object> tags;
    private Integer version;

    public UserProfile(Long id) {
        this.id = id;
        this.gender = 0;
        this.marriage = 0;
        this.tags = new HashMap<>();
        this.version = 0;
    }
}
