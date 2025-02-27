package com.aop.aophomework.controller;

import com.aop.aophomework.dto.ResponseWrapper;
import com.aop.aophomework.dto.UserDTO;
import com.aop.aophomework.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> findAll() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(ResponseWrapper.builder()
                .success(true)
                .code(HttpStatus.OK.value())
                .message("User list has successfully retrieved.")
                .data(users)
                .build());
    }
}
