package com.huangzichun.socialmediausermoduledomain.model;

import com.huangzichun.socialmediausermoduledomain.exception.DomainException;

public record Password (String value){
    public Password{
        if(value==null || value.trim().isEmpty()){
            throw new DomainException("密码不能为空");
        }
    }


}
