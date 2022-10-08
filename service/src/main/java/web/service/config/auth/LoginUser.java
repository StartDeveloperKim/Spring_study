package web.service.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 메서드의 파라미터로 선언된 객체에서만 사용할 수 있다. -> 어노테이션 위치 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    // @interface 어노테이션을 이용하여 이 파일을 어노테이션 클래스로 지정한다.
}
