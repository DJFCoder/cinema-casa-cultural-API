package com.senac.uc14.atv4.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(
        allowedHeaders = "*",
        allowCredentials = "true",
        originPatterns = "*"
)
@RequestMapping("/theme")
public class ThemeController {

    @PostMapping
    public ResponseEntity<Map<String, String>> salvarTema(
            @RequestParam String tema,
            HttpServletResponse response) {

        Cookie cookie = new Cookie("theme", tema);
        cookie.setMaxAge(365 * 24 * 3600);
        cookie.setPath("/");
        cookie.setHttpOnly(false);

        response.addCookie(cookie);

        Map<String, String> resultado = new HashMap<>();
        resultado.put("tema", tema);
        resultado.put("message", "Tema salvo com sucesso");

        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> lerTema(
            HttpServletRequest request) {

        String tema = "light";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("theme".equals(cookie.getName())) {
                    tema = cookie.getValue();
                    break;
                }
            }
        }

        Map<String, String> resultado = new HashMap<>();
        resultado.put("tema", tema);

        return ResponseEntity.ok(resultado);
    }
}
