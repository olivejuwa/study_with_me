package com.ksk.project.study_with_me.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    //TODO 권한에 맞춰서 URL 설정하기 (지금 유저만 가능하게 하는 거 안됨)

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/user/login", "/user/signup"
                            , "/board/study/list", "/board/place/list", "/board/question/list"
                            , "/css/**", "/img/**", "/js/**", "/h2-console/**"/*, ImageUtils.TEMP_PATH+"**"*/).permitAll()
//                    .antMatchers("/board/study/list", "/board/place/list/**", "/board/question/list/**").permitAll()
//                    .antMatchers("/board/study/posts/**", "/board/study/posts/save", "/board/place/posts/**", "/board/question/posts/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/user/processLogin")
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
