package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    //기본페이지 요청 메서드
    @GetMapping("/")
    public String index() {
        return "index"; // => templates 폴더의 index.html을 찾아감
    }
}
