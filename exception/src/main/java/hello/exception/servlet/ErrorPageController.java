package hello.exception.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ErrorPageController {

    @RequestMapping("/error-page/404")
    public String errorPage404(HttpServletRequest request, HttpServletResponse response) {
        log.info("errorPage404");
        return "error-page/404";
    }

    @RequestMapping("/error-page/500")
    public void errorPage500(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("errorPage 500");
        response.sendError(500);
    }
}
