package com.metacube.metacafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.metacafe.dto.UserDTO;
import com.metacube.metacafe.models.AddUserRequest;
import com.metacube.metacafe.service.user.UserService;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/user/add")
    public UserDTO addUser(@RequestBody AddUserRequest addUserRequest){
        return userService.addUser(addUserRequest);
    }

    @DeleteMapping("/admin/user/delete/{id}")
    public Boolean deleteUser(@PathVariable Integer id){
        Boolean isUserDeleted = true;
        try{
            userService.deleteUser(id);
        }catch(Exception e){
            isUserDeleted = false;
        }
        return isUserDeleted;
    }


}
