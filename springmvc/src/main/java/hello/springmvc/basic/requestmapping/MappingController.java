package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    /*RequestMapping은 method 설정이 없으면 GET, POST, PUT, DELETE 등등 다 받아들인다.*/
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /*편리한 축약 어노테이션
     * GET // POST // PUT // DELETE // PATCH*/
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /*
     * PathVariable 사용 --> 변수명이 같으면 생략 가능
     * 경로변수 자주 사용한다.
     * */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);

        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /*GetMapping에 조건부여 --> 잘 사용되지는 않음
     * AND 조건으로 params이 같이 넘어와야 Mapping 가능
     * */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /*특정 헤더로 추가 매핑*/
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /*
    * Content-Type 헤더 기반 추가 매핑 Media Type
    * 전달되는 타입이 JSON이여야 해당 URI와 Mapping 된다.
    * */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
}
