package com.ceu.HospitalManagement.controllers;

import com.ceu.HospitalManagement.entities.RO.UserRO;
import com.ceu.HospitalManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserRO userRO) {
        return ResponseEntity.ok(userService.save(userRO));
    }
}
