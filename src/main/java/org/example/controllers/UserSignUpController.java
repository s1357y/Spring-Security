package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserRegisterDto;
import org.example.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class UserSignUpController {

    private final UserService userService;

    @GetMapping
    public String signup(){
        return "signup";
    }

    @PostMapping
    public String signup(@ModelAttribute UserRegisterDto userDto){

        if(!userDto.getPassword().equals(userDto.getPasswordConfirm())){

        }
        userService.signup(
                userDto.getUsername(),
                userDto.getPassword(),
                "ROLE_USER"
        );

        return "redirect:login";
    }
}
