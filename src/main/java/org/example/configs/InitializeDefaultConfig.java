package org.example.configs;

import lombok.RequiredArgsConstructor;
import org.example.models.User;
import org.example.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 초기 상태 등록 Config
 */
@Configuration
@RequiredArgsConstructor
@Profile(value = "!test") // test 에서는 제외
public class InitializeDefaultConfig {

    private final UserService userService;

    /**
     * 유저등록, 어드민등록
     */
    @Bean
    public void initializeDefaultUser() {
        userService.signup("user", "user", "ROLE_USER");

        userService.signup("admin", "admin", "ROLE_ADMIN");
    }
}
