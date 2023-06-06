package com.example.service.admin;

import com.example.dto.admin.AdminLoginDto;
import com.example.dto.user.UserLoginDto;
import com.example.model.Admin;
import com.example.service.IGeneralService;

import java.util.List;

public interface AdminService extends IGeneralService<Admin> {
    List<AdminLoginDto> findAllByEmailAndPassword();
}
