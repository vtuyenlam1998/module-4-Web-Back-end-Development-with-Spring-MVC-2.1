package com.example.service.admin;

import com.example.payload.admin.AdminLoginDto;
import com.example.model.Admin;
import com.example.service.IGeneralService;

import java.util.List;

public interface AdminService extends IGeneralService<Admin> {
    List<AdminLoginDto> findAllByEmailAndPassword();
    AdminLoginDto findAdminById(Long id) throws Exception;
}
