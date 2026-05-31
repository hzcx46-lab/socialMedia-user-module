package com.huangzichun.socialmediausermoduledomain.port;
//接口方法，目的是生成或者一个新的id，被调用时自动生成下一个id
public interface IdGenerator {
    long nextId();
}
