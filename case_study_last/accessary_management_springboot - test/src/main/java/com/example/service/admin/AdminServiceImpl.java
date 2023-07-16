package com.example.service.admin;

import com.example.payload.admin.AdminLoginDto;
import com.example.model.Admin;
import com.example.model.Product;
import com.example.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<Admin> findAll() {
        return adminRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void softDelete(Long id) {
        adminRepository.updateByIsActiveFalse(id);
    }

    @Override
    public List<AdminLoginDto> findAllByEmailAndPassword() {
        List<Admin> admins = (List<Admin>) adminRepository.findAllByIsActiveTrue();
        return admins.stream().map(entity -> modelMapper.map(entity, AdminLoginDto.class)).collect(Collectors.toList());
    }

    @Override
    public AdminLoginDto findAdminById(Long id) throws Exception {
        Optional<Admin> admin = adminRepository.findByIdAndIsActiveTrue(id);
        return admin.stream().map(entity -> modelMapper.map(entity, AdminLoginDto.class)).findFirst().get();
    }
}
