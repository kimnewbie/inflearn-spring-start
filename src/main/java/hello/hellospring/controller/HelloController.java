package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// controller는 Controller라고 적어준다.
@Controller
public class HelloController {

    // url에서/hello라고 들어오면 이쪽으로 보내주는 게
    // @GetMapping
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!");
        return "hello";
    }
}
