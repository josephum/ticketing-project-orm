package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Injection to use
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //convertToEntity: When saving data into DB
    public User convertToEntity(UserDTO dto){
        return modelMapper.map(dto,User.class);
    }

    //convertToDto
    public UserDTO convertToDto(User entity){
        return modelMapper.map(entity, UserDTO.class);
    }
}
