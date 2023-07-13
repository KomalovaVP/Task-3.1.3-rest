package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User create(@RequestBody User newUser) {
        userService.add(newUser);
        return newUser;
    }

    @PutMapping
    public User edit(@RequestBody User editUser) {
        userService.updateUser(editUser);
        return editUser;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") int id){

        return userService.deleteUser(id);
    }
}
