package com.ex.identity.controller;

import com.ex.identity.dto.request.UserCreation;
import com.ex.identity.dto.request.UserUpdate;
import com.ex.identity.dto.response.ApiResponse;
import com.ex.identity.dto.response.UserResponse;

import com.ex.identity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    public ApiResponse<List<UserResponse>> getAllUsers(){
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUsers())
                .build();
    }
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable ("id") Long id){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(id))
                .build();
    }
    @PostMapping()
    public ApiResponse<UserResponse> createUser(@RequestBody UserCreation request){
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }
    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable ("id") Long id,
                                                @RequestBody UserUpdate request){
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(id,request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable ("id") Long id){
        userService.deleteUser(id);
        return ApiResponse.<String>builder()
                .result("User has been delete")
                .build();
    }

}
