package com.korit.BoardStudy.mapper;

import com.korit.BoardStudy.entity.Oauth2User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface OAuth2UserMapper {
    Optional<Oauth2User> getOAuth2UserByProviderAndProviderUserId(String provider, String providerUserId);
    int addOAuth2User(Oauth2User oAuth2User);
}
