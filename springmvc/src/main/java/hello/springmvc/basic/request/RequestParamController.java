package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    /*요청 파라미터 Servlet 형식으로 받기
     * HttpServletRequest // HttpServletResponse
     * */
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    /* @ResponseBody 어노테이션
    *  일반 Controller로 설정한 Controller에서 반환값을 View의 논리적인 경로러 설정하는 것이 아닌
    *  HTTP의 Message Body에 담아서 바로 전송하고자 할 때 사용하는 어노테이션
    * */
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge){

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){
        
        /*넘어오는 파라미터의 이름과 RequestParam에서 설정한 이름이 동일하다면 생략가능*/
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        /*RequestParam을 아예 생략가능하다
        * 대신 요청 파라미터와 이름이 일치해야한다.*/
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer age){

        /* RequestParam에서 자료형을 지정할 때
        *  기본 자료형(int, char, short ...)로 지정하면 null이 들어갈 수 없다.
        *  그래서 required = false 설정을 하더라도 오류가 난다.
        *  이럴 때는 wrapper class(Integer, String...)을 사용해야한다.
        * */

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age){

        /*defaultValue 설정은 빈문자일 경우에도 defaultValue 처리를 해준다.*/
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        /* ModelAttribute
        *  ModelAttribute를 사용하면 해당되는 객체를 자동으로 생성해주고
        *  전달되는 프로퍼티와 객체의 프로퍼티를 조회하고 일치하는 이름이 있다면
        *  set Method를 이용하여 해당 객체에 프로퍼티 값을 전달되는 값으로 변경한다.
        * */
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        /* ModelAttribute
         *  생략가능... 쩐다...
         * */
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
