    package com.example.forumapp.controller;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import com.example.forumapp.model.User;
    import com.example.forumapp.service.AuthService;

    @Controller
    @RequestMapping("/auth")
    public class AuthController {

        @Autowired
        private AuthService authService;

     
        @GetMapping("/register")
        public String showRegisterPage() {
            return "register"; 
        }

        
        @PostMapping("/register")
        public String registerUser(@ModelAttribute User user, Model model) {
            try {
                authService.registerUser(user); 
                model.addAttribute("success", "Kayıt başarılı! Giriş yapabilirsiniz.");
            } catch (Exception e) {
                model.addAttribute("error", "Hata: " + e.getMessage());
            }
            return "register"; 
        }

        
        @GetMapping("/login")
        public String showLoginPage() {
            return "login"; 
        }

    
        @PostMapping("/login")
        public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
            if (authService.authenticateUser(username, password).isPresent()) {
                return "redirect:/forum";
            } else {
                model.addAttribute("error", "Geçersiz kullanıcı adı veya şifre.");
                return "login"; 
            }
        }
    }
