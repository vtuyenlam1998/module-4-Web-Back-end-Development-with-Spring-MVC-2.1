package com.example.service.user;

import com.example.dto.user.UserLoginDto;
import com.example.model.User;
import com.example.service.IGeneralService;

import java.util.List;

public interface UserService extends IGeneralService<User> {
    List<UserLoginDto> findAllByEmailAndPassword();
}
