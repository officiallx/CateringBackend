package org.obnoxious.controllers;

import org.obnoxious.Service.impl.UserDetailsServiceImpl;
import org.obnoxious.entities.ApplicationUser;
import org.obnoxious.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@CrossOrigin(origins= {"*" }, allowedHeaders="*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @GetMapping("/users")
    public List<ApplicationUser> getAllUsers() {
        return userDetailsService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public ApplicationUser getUser(@PathVariable String username) {
        return userDetailsService.getUser(username);
    }
}