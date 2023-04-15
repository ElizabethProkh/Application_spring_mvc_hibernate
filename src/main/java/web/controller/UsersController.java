package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String startPage() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/add")
    public String addNewUser(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "addNewUser";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getWithId(@PathVariable("id") int id, Model model) {
        model.addAttribute("userId", userService.getUser(id));
        return "getUserWithId";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "userEdit";
    }

    @PatchMapping("users/{id}/edit")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
