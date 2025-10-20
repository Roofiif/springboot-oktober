package com.id.co.bpddiy.social.service;

import com.id.co.bpddiy.social.dto.UserDto;
import com.id.co.bpddiy.social.model.User.Role;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto createUser(String username, String email, String password, Role role);

    UserDto updateUser(Long id, String username,String email,String password, Role role);

    UserDto deleteUser(Long id);
}
