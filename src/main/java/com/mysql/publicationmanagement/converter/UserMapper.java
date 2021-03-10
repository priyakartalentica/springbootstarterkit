package com.mysql.publicationmanagement.converter;

import com.mysql.publicationmanagement.model.UserRegistration;
import com.mysql.publicationmanagement.dto.UserDTO;

import java.util.List;

//@Mapper
public interface UserMapper {
    //UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    UserDTO toUserDTO(UserRegistration user);
    UserRegistration toUser(UserDTO userDTO);
    List<UserDTO> toUserDTOList(List<UserRegistration> userList);
    List<UserRegistration>    toUserList(List<UserDTO> userDTOList);

}
