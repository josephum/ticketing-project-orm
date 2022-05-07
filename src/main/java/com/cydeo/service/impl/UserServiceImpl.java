package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return userRepository.findAll(Sort.by("firstName")).stream()
                .map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return userMapper.convertToDto(userRepository.findByUserName(username));
    }

    @Override
    public void save(UserDTO dto) {
        userRepository.save(userMapper.convertToEntity(dto));
    }

    @Override
    public UserDTO update(UserDTO dto) {
        // Find user in DB
        User user = userRepository.findByUserName(dto.getUserName());
        // Convert from DTO
        User convertedUser = userMapper.convertToEntity(dto);
        // Set Id in converted to Entity
        convertedUser.setId(user.getId());
        // Save
        userRepository.save(convertedUser);
        return findByUserName(dto.getUserName());
    }

    @Override
    public void deleteUserByName(String username) {
        userRepository.deleteUserByUserName(username);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);
    }
}
