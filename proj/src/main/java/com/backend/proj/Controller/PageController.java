package com.backend.proj.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class PageController {

        @GetMapping("/")
        public String login() {
            return "Welocome to springt boot ";
        }


    }

