package com.id.co.bpddiy.social.service;

import com.id.co.bpddiy.social.dto.UserDto;
import com.id.co.bpddiy.social.model.User;
import com.id.co.bpddiy.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    // DI
    @Autowired
    // mengurangi deklarasi dengan new
    // mengurangi pembuatan objek baru di memory
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user ->
            new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getBio(),
                user.getRole()
            )
        ).toList();
    }

    @Override
    public UserDto createUser(String username, String email, String password, User.Role role) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        User userResult= userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setUsername(userResult.getUsername());
        userDto.setEmail(userResult.getEmail());
        userDto.setRole(userResult.getRole());
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, String username, String email, String password, User.Role role) {
        User userResult = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Tidak Ditemukan"));

        userResult.setUsername(username);
        userResult.setEmail(email);
        userResult.setPassword(password);
        userResult.setRole(role);
        userRepository.save(userResult);

        UserDto userDto = new UserDto();
        userDto.setUsername(userResult.getUsername());
        userDto.setEmail(userResult.getEmail());
        userDto.setRole(userResult.getRole());
        return userDto;
    }

    @Override
    public UserDto deleteUser(Long id) {
        User userResult = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Tidak Ditemukan"));

        userRepository.delete(userResult);

        UserDto userDto = new UserDto();
        userDto.setUsername(userResult.getUsername());
        userDto.setEmail(userResult.getEmail());
        userDto.setRole(userResult.getRole());
        return userDto;
    }
}
