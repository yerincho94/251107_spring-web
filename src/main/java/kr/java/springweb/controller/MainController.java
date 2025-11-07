package kr.java.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // @Component 스캔의 대상이됨.
//@RestController // REST API 형태로 -> 페이지가 아니라 데이터를 전달하는 방식
@RequestMapping // ("/")
public class MainController {
    /*@GetMapping // ("/")
    public String hello() {
        return "hello spring";
    }*/

    @GetMapping
    public String hello() {
//        return "hello.jsp"; // forward
//        return "WEB-INF/views/hello.jsp"; // forward
        return "hello"; // view resolver가 작동하면서 앞뒤에 prefix suffix 경로를 붙여줌.
    }
}
