package com.korit.BoardStudy.dto.oauth2;

import com.korit.BoardStudy.entity.Oauth2User;
import lombok.Data;

@Data
public class OAuth2MergeReqDto {
    private String username;
    private String password;
    private String provider;
    private String providerUserId;

    public Oauth2User toOAuth2User(Integer userId) {
        return Oauth2User.builder()
                .userId(userId)
                .provider(provider)
                .providerUserId(providerUserId)
                .build();
    }
}
