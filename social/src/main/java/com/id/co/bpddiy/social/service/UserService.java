package com.id.co.bpddiy.social.service;

import com.id.co.bpddiy.social.dto.UserDto;
import com.id.co.bpddiy.social.dto.UserProfileUpdateDto;
import com.id.co.bpddiy.social.model.User;
import com.id.co.bpddiy.social.model.User.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    /**
     * Mengambil semua pengguna tanpa pagination.
     */
    List<UserDto> getAll();

    /**
     * Membuat user baru.
     */
    UserDto createUser(String username, String email, String password, Role role);

    /**
     * Memperbarui data user berdasarkan ID.
     */
    UserDto updateUser(Long id, String username, String email, String password, Role role);

    /**
     * Menghapus user berdasarkan ID.
     */
    UserDto deleteUser(Long id);

    // Start Here
    /**
     * Mengambil entitas user berdasarkan ID.
     */
    User getUserById(Long userId);

    /**
     * Memperbarui profil user (nama lengkap, bio, dan foto profil).
     */
    UserDto updateProfile(Long userId, UserProfileUpdateDto updateDto);

    /**
     * Memperbarui hanya foto profil user.
     */
    UserDto updateProfileImage(Long userId, String imageUrl);

    /**
     * Mengambil semua user dengan pagination, pencarian, dan filter role.
     */
    Page<UserDto> getAllUsers(String search, Role role, Pageable pageable);
}