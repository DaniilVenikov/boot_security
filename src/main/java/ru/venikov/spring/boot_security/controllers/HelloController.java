package ru.venikov.spring.boot_security.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.venikov.spring.boot_security.security.OurUserDetails;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OurUserDetails userDetails = (OurUserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUser());

        return "hello";
    }
}
