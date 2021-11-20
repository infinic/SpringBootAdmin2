package ru.infinic.springbootadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Oleg Kadochnikov
 */

@Controller
@RequestMapping()
public class CommonController {

    @GetMapping("/")
    public String mainPage(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else {
            return "redirect:/user";
        }
    }

    @GetMapping("/admin")
    public String adminMainPage() {
        return "redirect:/admin/users";
    }

}
