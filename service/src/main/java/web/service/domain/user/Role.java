package web.service.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    /*
    * 스프링 시큐리티에서 권환 코드에는 항상 ROLE_이 앞에 있어야한다.
    * 그래서 코드별 키 값을 아래와 같이 지어준 것이다.
    * */
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
