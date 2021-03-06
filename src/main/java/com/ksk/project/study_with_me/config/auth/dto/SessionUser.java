package com.ksk.project.study_with_me.config.auth.dto;

import com.ksk.project.study_with_me.domain.user.Role;
import com.ksk.project.study_with_me.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

// TODO 프로필 기능 추가 여부 : 필드 추가, 생성자 수정
@Getter
public class SessionUser implements Serializable {
    private Long userCode;
    private String name;
    private String email;
    private String nickname;
    private String role;
    private String socialCode;

    public SessionUser(User user) {
        this.userCode = user.getUserCode();
        this.name = user.getName();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.role = user.getRoleKey();
        this.socialCode = user.getSocialCode();
    }

    public User toEntity() {
        return User.builder()
                .userCode(userCode)
                .name(name)
                .email(email)
                .role(Role.findRole(role))
                .nickname(nickname)
                .socialCode(socialCode)
                .build();
    }
}
