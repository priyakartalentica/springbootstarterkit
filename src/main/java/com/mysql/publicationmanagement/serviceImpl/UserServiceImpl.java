package com.mysql.publicationmanagement.serviceImpl;

import com.mysql.publicationmanagement.converter.UserMapper;
import com.mysql.publicationmanagement.converterImpl.UserMapperImpl;
import com.mysql.publicationmanagement.dto.UserDTO;
import com.mysql.publicationmanagement.model.UserRegistration;
import com.mysql.publicationmanagement.repositories.UserRepository;
import com.mysql.publicationmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl() {
        userMapper =new UserMapperImpl();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO getUsersByID(Long Id) {

        UserDTO userDTO = userMapper.toUserDTO(userRepository.getOne(Id));
        return userDTO;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserRegistration user = userMapper.toUser(userDTO);
        user.setCreatedOn(new java.util.Date());
        user.setUpdatedOn(new java.util.Date());
        return userMapper.toUserDTO(userRepository.saveAndFlush(user));
    }

    @Override
    public UserDTO updateUser(Long Id, UserDTO userDTO) {
        UserRegistration modifiedUser = userMapper.toUser(userDTO);
        UserRegistration oldUser = userRepository.getOne(Id);
        oldUser.setUpdatedOn(new java.util.Date());
        oldUser.setPassword(modifiedUser.getPassword());
        oldUser.setUsername(modifiedUser.getUsername());
        return userMapper.toUserDTO(userRepository.saveAndFlush(oldUser));
    }

    @Override
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }
}
