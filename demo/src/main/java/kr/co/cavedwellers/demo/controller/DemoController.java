package kr.co.cavedwellers.demo.controller;

import kr.co.cavedwellers.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // 정적
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello..!!!");
        return "hello";
    }

    // 동적
    @GetMapping("dynamic")
    public String dynamic(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "dynamic";
    }

    // 페이지 없이 바로 출력
    @GetMapping("direct")
    @ResponseBody
    public String directName(@RequestParam("name") String name) {
        return "directName : " + name;
    }
}
