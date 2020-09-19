package com.noyo0123.backoffice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 스프링부트 설정파일이라고 알림
@EnableJpaAuditing // JPA에 대해 감시자 설정
public class JpaConfig {
}
