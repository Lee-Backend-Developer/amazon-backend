package com.amazon_clone.amazon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginFailureListener {

    @EventListener
    public void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event) {
        // 로그인 실패 시 처리할 로직을 여기에 작성합니다.
        // 예: 로그 기록, 알림 전송 등
        log.info("로그인 실패 {}", event.getAuthentication().getPrincipal());
    }
}
