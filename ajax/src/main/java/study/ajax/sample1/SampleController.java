package study.ajax.sample1;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@Slf4j
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/get-text")
    public String getText() {
        log.info("MIME TYPE: {}", MediaType.TEXT_PLAIN_VALUE);

        return "안녕하세요요용";
    }

    @GetMapping("/get-sample")
    public SampleVO getSample() {
        return new SampleVO(112, "김", "태우");
    }

    @GetMapping("/get-list")
    public List<SampleVO> getList() {
        return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + "Last"))
                .collect(Collectors.toList());
    }

    @GetMapping("get-map")
    public Map<String, SampleVO> getMap() {
        Map<String, SampleVO> map = new HashMap<>();

        map.put("First", new SampleVO(111, "아이언맨", "토니스타크"));
        map.put("Second", new SampleVO(222, "아이엠", "그루트"));

        return map;
    }

    @GetMapping("/check")
    public ResponseEntity<SampleVO> check(@RequestParam Double height,
                                          @RequestParam Double weight) {
        SampleVO vo = new SampleVO(0, "" + height, "" + weight);

        ResponseEntity<SampleVO> result = null;

        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo);
        }

        return result;
    }

    @GetMapping("/product/{cat}/{pid}")
    public String[] getPath(@PathVariable("cat") String cat,
                            @PathVariable("pid") Integer pid) {
        return new String[]{"category: " + cat, "productId: " + pid};
    }

    /**
     * @RequestBody는 JSON을 받고 대칭되는 객체가 있다면 그 객체를 자동생성 후 데이터 주입까지 한다.
     * @param param
     * @return
     */
    @GetMapping("/reservation")
    public String setReservation(@RequestBody Map<String, String> param) {
        String id = param.get("id");
        String pwd = param.get("pwd");
        String email = param.get("email");

        log.info("id:{}, pwd:{}, email:{}", id, pwd, email);
        return "성공";
    }
}
