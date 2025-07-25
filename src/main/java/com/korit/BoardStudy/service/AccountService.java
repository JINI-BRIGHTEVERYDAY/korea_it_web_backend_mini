package com.korit.BoardStudy.service;

import com.korit.BoardStudy.dto.ApiRespDto;
import com.korit.BoardStudy.dto.account.ChangePasswordReqDto;
import com.korit.BoardStudy.entity.User;
import com.korit.BoardStudy.model.PrincipalUser;
import com.korit.BoardStudy.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApiRespDto<?> changePassword(ChangePasswordReqDto changePasswordReqDto, PrincipalUser principalUser) {
        Optional<User> userByUserId = userRepository.getUserByUserId(principalUser.getUserId());
        if (userByUserId.isEmpty()) {
            return new ApiRespDto<>("failed", "존재하지 않는 사용자입니다.", null);
        }

        if (!Objects.equals(changePasswordReqDto.getUserId(), principalUser.getUserId())) {
            return new ApiRespDto<>("failed", "잘못된 요청입니다.", null);
        }

        if (!bCryptPasswordEncoder.matches(changePasswordReqDto.getOldPassword(), userByUserId.get().getPassword())) {
            return new ApiRespDto<>("failed", "기존 비밀번호가 일치하지 않습니다.", null);
        }

        if (bCryptPasswordEncoder.matches(changePasswordReqDto.getNewPassword(), userByUserId.get().getPassword())) {
            return new ApiRespDto<>("failed", "새 비밀번호는 기존 비밀번호와 같아야 합니다.", null);
        }
    }
}
