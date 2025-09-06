package com.vipusa.oAuthPractise.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class DemoController {

    @GetMapping("/")
    public String home() {
        return "index"; // homepage with navigation buttons
    }

    @GetMapping("/public")
    public String publicApi(Model model) {
        model.addAttribute("message", "This Is Public API");
        return "public"; // templates/public.html
    }

    @GetMapping("/private")
    public String privateApi(OAuth2AuthenticationToken token, Model model) {
        Map<String, Object> attributes = token.getPrincipal().getAttributes();

        model.addAttribute("message", "This Is Private API");
        model.addAttribute("userAttributes", attributes);

        return "private"; // templates/private.html
    }
}
