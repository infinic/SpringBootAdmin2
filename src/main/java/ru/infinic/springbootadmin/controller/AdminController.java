package ru.infinic.springbootadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.infinic.springbootadmin.model.User;
import ru.infinic.springbootadmin.service.RoleService;
import ru.infinic.springbootadmin.service.UserService;

/**
 * @author Oleg Kadochnikov
 */

@Controller
@RequestMapping("/admin/users")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String getUsers(Model model) {
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "pages/users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user, Model model) {
        System.out.println("User roles: ");
        System.out.println(user.getRoles());
        userService.createUser(user);
        return "redirect:/admin/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(userService.getUserById(id).getPassword());
        }
        userService.updateUserById(id, user);
        return "redirect:/admin/users";
    }

    @DeleteMapping()
    public String deleteUser(@ModelAttribute("user") User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        userService.deleteUser(user);
        return "redirect:/admin/users";
    }
}
