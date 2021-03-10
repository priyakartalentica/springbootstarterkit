package com.mysql.publicationmanagement.controller;

import com.mysql.publicationmanagement.dto.UserDTO;
import com.mysql.publicationmanagement.service.UserService;
import com.mysql.publicationmanagement.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
        userService=new UserServiceImpl();
    }

    @GetMapping
    public List<UserDTO> getallusers(){

        return userService.getAllUsers();
    }



    @GetMapping
    @RequestMapping("{id}")
    public UserDTO getoneUser(@PathVariable Long id){

        return userService.getUsersByID(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteuser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){

        return userService.updateUser(id, userDTO);
    }
}
