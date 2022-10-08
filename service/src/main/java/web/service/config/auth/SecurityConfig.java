package web.service.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import web.service.domain.user.Role;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 스프링 시큐리티 설정들을 활성화시켜 준다.
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity 객체를 많이 사용한다. 보안에 관련된 역할과 많은 책임을 가지고 있다.
        /*
        * csrf(Cross Site Request Forgery)란?
        * - 사이트간 위조 요청,
        * - spring security에서 default로 설정된다. GET요청을 제외하고 상태를 변화시킬 수 있는 POST, PUT, DELETE 요청으로부터 보호한다.
        * - disable()로 설정하여 이 기능을 꺼버렸다.
        * */

        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeHttpRequests() // URL별 권환 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        return http.build();
    }
}
