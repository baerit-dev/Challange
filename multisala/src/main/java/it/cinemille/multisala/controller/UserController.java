package it.cinemille.multisala.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Boolean> login(@RequestParam String user, @RequestParam String password) {
        return Mono.just(user.equals("user") && password.equals("password"));
    }
}
