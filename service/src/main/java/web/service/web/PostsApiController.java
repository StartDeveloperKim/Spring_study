package web.service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.service.service.posts.PostsService;
import web.service.web.dto.PostsResponseDto;
import web.service.web.dto.PostsSaveRequestDto;
import web.service.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor // final이 붙은 필드값에 대한 생성자를 자동으로 생성해준다.
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
