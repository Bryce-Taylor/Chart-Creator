package com.example.Chart.Creator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrameTemplate {
    @GetMapping("/")
    public String getHome() {
        return "home.html";
    }
}
