package com.mysql.publicationmanagement.service;

import com.mysql.publicationmanagement.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    UserDTO getUsersByID(Long Id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long Id, UserDTO userDTO);
    void deleteUser(Long Id);
}
