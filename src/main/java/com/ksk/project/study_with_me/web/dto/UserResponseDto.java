package com.ksk.project.study_with_me.web.dto;

import com.ksk.project.study_with_me.domain.user.Role;
import com.ksk.project.study_with_me.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String name;
    private String email;
    private String role;
    private String socialCode;
    private String nickname;

    public UserResponseDto(User entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.role = entity.getRoleKey();
        this.socialCode = entity.getSocialCode();
        this.nickname = entity.getNickname();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .nickname(nickname)
                .socialCode(socialCode)
                .build();
    }
}
