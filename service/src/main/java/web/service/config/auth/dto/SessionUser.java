package web.service.config.auth.dto;

import lombok.Getter;
import web.service.domain.user.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    // Serializable 인터페이스를 상속받으면 JVM(Java Vritual Machine)에서 해당 객체를 직렬화 해준다.
    // 이 파일에서 Session에 저장하는 객체로서 SessionUser 클래스를 사용하는데 이를 DB에 저장해야하기 때문에 해당 인터페이스가 필요한 것 같다,
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getEmail();
    }
}
