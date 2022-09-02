package hello.itemservice.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId";
    /*동시성문제 때문에 ConcurrentHashMap을 사용해야함*/
    private final Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    /**
     ** 세션 생성
     * UUID를 통해 랜덤한 문자열을 생성한다.
     * Map에 해당 seesionId를 key로 전달된 객체를 value로 저장한다.
     * 이 sessionId로 전달하는 쿠키를 생성하고 이를 response 객체에 담는다.
     * */
    public void createSession(Object value, HttpServletResponse response) {

        //세션 ID를 생성하고, 값을 세션에 저장
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        //쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);

    }

    /**
     * 세션 조회
     * request 객체에서 쿠키이름을 찾는다.
     * null이라면 null반환 세션저장소에서 이 sessionId에 대한 객체를 찾아 반환한다.
     */
    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue()); // UUID(SessionID) 반환
    }

    /**
     * 세션만료(로그아웃)
     * request객체에서 cookie를 찾는다.
     * sessionCookie가 null이 아니라면 sessionStore에서 해당 sessionId에 대한 값을 찾아 삭제한다.
     */
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }
}
