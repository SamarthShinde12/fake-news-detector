package com.fakenews.controller;

import com.fakenews.service.PredictionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller   // ✅ MUST be @Controller (NOT @RestController)
public class NewsController {

    private final PredictionService service;

    public NewsController(PredictionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";   // maps to index.html
    }

    @PostMapping("/predict")
    public String predict(@RequestParam("news") String news, Model model) throws Exception {
        String result = service.predict(news);
        model.addAttribute("result", result);
        return "index";
    }
}
