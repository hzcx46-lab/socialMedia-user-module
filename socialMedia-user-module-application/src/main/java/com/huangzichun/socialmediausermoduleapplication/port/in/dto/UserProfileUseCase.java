package src.main.java.com.huangzichun.socialmediausermoduleapplication.port.in.dto;

import com.wuyunbin.quadra.user.application.port.in.command.UserProfileCommand;
import com.wuyunbin.quadra.user.application.port.in.dto.UserProfileResultDTO;

import java.util.List;

public interface UserProfileUseCase {

    void createOrUpdateProfile(UserProfileCommand command);

    UserProfileResultDTO getProfile(Long id);

    List<UserProfileResultDTO> pageQuery(int page, int size, String nickname, String city, String education);

    long countProfiles(String nickname, String city, String education);

    void softDelete(Long id);
}