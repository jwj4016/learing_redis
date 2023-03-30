package com.example.learing_redis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class LoginController {
    HashMap<String, String> sessionMap = new HashMap<>();


    @GetMapping("/login")
    public void login(HttpSession session, @RequestParam String name) {
        sessionMap.put(session.getId(), name);
    }

    @GetMapping("/login/my-name")
    public String getMyName(HttpSession session) {
        return sessionMap.get(session.getId());
    }
}
