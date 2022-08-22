package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController/*어떤것을 반환하면 해당 반환체가 그대로 반환된다.*/
public class logTestController {

    /*log 출력을 위한 선언 org.slf4j로 선언한다.*/
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        /*아래의 순서가 로그의 레벨 순서다
        * 1.trace // 2.debug
        * 3. info // 4. warn // 5. error
        * */
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);

        log.info(" info log={}", name); /*log출력 문장*/
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
