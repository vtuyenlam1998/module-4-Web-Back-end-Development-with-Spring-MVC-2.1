package com.example.service.user;

import com.example.payload.user.RoleDto;
import com.example.payload.user.UserDto;
import com.example.payload.user.UserLoginDto;
import com.example.model.User;
import com.example.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends IGeneralService<UserDto> {
    Iterable<UserDto> findAllByRole(RoleDto roleDto);
    Iterable<UserDto> findAll();
    Page<UserDto> findAll(Pageable pageable);
    Page<UserDto> findAllByFullNameContaining(String fullName, Pageable pageable);

    boolean isAuthenticated();
}
