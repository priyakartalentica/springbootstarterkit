package com.mysql.publicationmanagement.converterImpl;

import com.mysql.publicationmanagement.converter.UserMapper;
import com.mysql.publicationmanagement.dto.UserDTO;
import com.mysql.publicationmanagement.model.UserRegistration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO toUserDTO(UserRegistration user) {
        UserDTO dto=new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setPassword("*****");
        return dto;
    }

    @Override
    public UserRegistration toUser(UserDTO userDTO) {
        UserRegistration user=new UserRegistration();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
                //new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        return  user;
    }

    @Override
    public List<UserDTO> toUserDTOList(List<UserRegistration> userList) {
        List<UserDTO> dtoList=new ArrayList<>();
        for(UserRegistration user : userList){
            dtoList.add(toUserDTO(user));
        }
        return dtoList;
    }

    @Override
    public List<UserRegistration> toUserList(List<UserDTO> userDTOList) {
        List<UserRegistration> userList=new ArrayList<>();
        for(UserDTO dto: userDTOList){
            userList.add(toUser(dto));
        }
        return userList;
    }
}
