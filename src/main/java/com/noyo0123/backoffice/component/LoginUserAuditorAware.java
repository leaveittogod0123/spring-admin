package com.noyo0123.backoffice.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer");
        /**
         * @EntityListeners(AuditingEntityListener.class) 달린 엔티티의 경우
         * @LastModifiedBy, @CreatedBy 어노테이션 붙은 엔티티 컬럼은 위에 설정한 값이 들어감.
         * @CreatedDate, @LastModifiedDate 도
         */
    }
}
