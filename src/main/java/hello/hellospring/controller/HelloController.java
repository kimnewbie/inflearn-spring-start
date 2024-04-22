package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// controller는 Controller라고 적어준다.
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!");
        return "hello";
    }

    // @RequestParam 외부에서 직접 받음
    @GetMapping("hello-mvc")
    // public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // http://localhost:8080/hello-mvc?name=yj
        // 파라미터 써서 넘기기
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    // 응답 body부에 넣겠다는 표시
    // html 표시 없이 문자만 내려가는 형태
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    
    // JSON 방식으로 넘기기
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // class 안에 static을 붙이면 class 생성 가능
    static class Hello {
        private String name;

        // 단축키 alt + insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
