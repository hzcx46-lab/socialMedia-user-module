package com.huangzichun.socialmediausermoduledomain.port;

import com.huangzichun.socialmediausermoduledomain.model.User;
import com.huangzichun.socialmediausermoduledomain.model.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByMobile(String mobile);
    User save(User user);
    boolean existsByMobile(String mobile);

    Optional<UserProfile> findProfileById(Long id);
    void saveUserProfile(UserProfile profile);
    void updateUserProfile(UserProfile profile);
    List<UserProfile> findProfilesByPage(int offset, int limit, String nickname, String city, String education);
    long countProfiles(String nickname, String city, String education);
    void softDeleteUser(Long id);

}
