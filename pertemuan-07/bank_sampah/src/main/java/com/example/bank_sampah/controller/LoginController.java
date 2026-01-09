package com.example.bank_sampah.controller;

import com.example.bank_sampah.model.User;
import com.example.bank_sampah.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login-process")
    public String processLogin(
        @RequestParam String username,
        @RequestParam String password,
        Model model
    ) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            
            if (user.getPassword().trim().equals(password.trim())) {
                return "redirect:/dashboard";
            }
        }

        model.addAttribute("error", "Username / password salah!");
        return "login";
    }
}