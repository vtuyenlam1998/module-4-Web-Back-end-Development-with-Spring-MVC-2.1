package com.example.formatter;

import com.example.payload.user.RoleDto;
import com.example.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class RoleFormatter implements Formatter<RoleDto> {

    private RoleService roleService;

    @Autowired
    public RoleFormatter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto parse(String text, Locale locale) {
        Optional<RoleDto> roleDto = null;
        try {
            roleDto = roleService.findById(Long.parseLong(text));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return roleDto.orElse(null);
    }

    @Override
    public String print(RoleDto object, Locale locale) {
        return "[" + object.getId() + ", "
                + object.getName() + ", "
                + object.getDesc() + "]";
    }
}