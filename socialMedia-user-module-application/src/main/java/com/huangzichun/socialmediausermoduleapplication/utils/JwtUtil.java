package com.huangzichun.socialmediausermoduleapplication.utils;

import org.springframework.stereotype.Service;


@Service
public class LoginApplicationService implements UserLoginUseCase {

    private final UserLoginDomainService userLoginDomainService;
    private final JwtUtil jwtUtil;

    public LoginApplicationService(
            UserLoginDomainService userLoginDomainService,
            JwtUtil jwtUtil) {
        this.userLoginDomainService = userLoginDomainService;
        this.jwtUtil =jwtUtil;
    }
