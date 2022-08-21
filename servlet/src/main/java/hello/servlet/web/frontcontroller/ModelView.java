package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class ModelView {
    private String viewName; // jsp 파일의 이름
    private Map<String, Object> model = new HashMap<>(); // Model 객체

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
