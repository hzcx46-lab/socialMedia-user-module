package com.huangzichun.socialmediausermoduledomain.model;

import com.huangzichun.socialmediausermoduledomain.exception.DomainException;
//record紧凑构造器,record Password (String value)构造出一个领域对象
public record Password (String value){
    //实现 密码不能为空的校验
    public Password{
        if(value==null || value.trim().isEmpty()){
            throw new DomainException("密码不能为空");
        }
    }

}
