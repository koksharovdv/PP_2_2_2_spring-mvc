package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model, @RequestParam(defaultValue = "10") int count) {
        List<User> users = userService.getUsers(count);
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/edit?id=1")
    public String editUsers(Model model, @RequestParam Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";

    }
    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/users";
    }
    @PostMapping
    public String addUser(@Validated @ModelAttribute User user,
                          BindingResult bindingResult,
                          Model model,@RequestParam(required = false) Integer count) {
        if (bindingResult.hasErrors()) {
            int safeCount = (count == null) ? 10 : count;

            List<User> users = userService.getUsers(safeCount);
            model.addAttribute("users", users);
            return "users";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
