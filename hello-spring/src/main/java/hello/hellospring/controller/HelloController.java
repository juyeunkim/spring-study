package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello");
        return "hello"; // resources/templates에서 "hello"에 일치하는 html파일을 찾는다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body에 데이터를 직접 넣어준다
    public String helloString(@RequestParam(value = "name")String name){
        return "hello "+name; // html이 아닌 text형태
    }

    @GetMapping("hello-api")
    @ResponseBody // http의 body에 데이터를 직접 넣어준다
    public Hello helloApi(@RequestParam(value = "name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // html이 아닌 object(json) 형태
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
