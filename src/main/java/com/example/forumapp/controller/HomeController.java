package com.example.forumapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/forum/yeni")
    public String yeniBaslayanlarPage() {
        return "yeni-baslayanlar"; 
    }

    @GetMapping("/forum/sikca")
    public String sikcaSorulanSorularPage() {
        return "sikca-sorulan-sorular"; 
    }

    @GetMapping("/forum/topluluk")
    public String toplulukKurallariPage() {
        return "topluluk-kurallari"; 
    }
  
    @GetMapping("/forum/index")
    public String showHomePage() {
        return "index"; 
    }
}
