package ru.infinic.springbootadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Oleg Kadochnikov
 */

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "pages/login";
    }

}
