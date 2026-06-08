package com.huangzichun.socialmediausermoduledomain.service;

import com.huangzichun.socialmediausermoduledomain.exception.DomainException;
import com.huangzichun.socialmediausermoduledomain.model.UserProfile;
import com.huangzichun.socialmediausermoduledomain.port.UserRepository;

import java.util.List;

public class UserProfileDomainService {
    private final UserRepository userRepository;

    public UserProfileDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createOrUpdateProfile(UserProfile profile) {
        if (profile.getId() == null || profile.getId() <= 0) {
            throw new DomainException("用户ID不能为空");
        }
        userRepository.findProfileById(profile.getId())
                .ifPresentOrElse(
                        existing -> userRepository.updateUserProfile(profile),
                        () -> userRepository.saveUserProfile(profile)
                );
    }

    public UserProfile getProfile(Long id) {
        if (id == null || id <= 0) {
            throw new DomainException("用户ID不能为空");
        }
        return userRepository.findProfileById(id)
                .orElseThrow(() -> new DomainException("用户资料不存在"));
    }

    public List<UserProfile> pageQuery(int page, int size, String nickname, String city, String education) {
        int offset = (page - 1) * size;
        return userRepository.findProfilesByPage(offset, size, nickname, city, education);
    }

    public long countProfiles(String nickname, String city, String education) {
        return userRepository.countProfiles(nickname, city, education);
    }

    public void softDelete(Long id) {
        if (id == null || id <= 0) {
            throw new DomainException("用户ID不能为空");
        }
        userRepository.softDeleteUser(id);
    }

}
