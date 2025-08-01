package com.korit.BoardStudy.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OAuth2PrincipalUserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();

        String provider = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("provider : " + provider);
        String email = null;
        String id = null;

        switch (provider) {
            case "google":
                id = attributes.get("sub").toString();
                email = (String) attributes.get("email");
                break;
            case "naver":
                Map<String, Object> response = (Map<String, Object>) attributes.get("response");
                id = response.get("id").toString();
                email = (String) response.get("email");
                break;
            case "kakao":
                id = attributes.get("id").toString();
                Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
                email = "ehddbs7212@gmail.com";
                break;
        }

        Map<String, Object> newAttributes = Map.of(
                "id", id,
                "provider", provider,
                "email", email
        );

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_TEMPORARY"));

        return new DefaultOAuth2User(authorities, newAttributes, "id");
    }
}
