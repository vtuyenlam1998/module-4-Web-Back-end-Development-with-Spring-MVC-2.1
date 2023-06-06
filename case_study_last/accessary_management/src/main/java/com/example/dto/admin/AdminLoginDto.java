package com.example.dto.admin;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminLoginDto {
    private Long id;
    private String email;
    private String password;
}
