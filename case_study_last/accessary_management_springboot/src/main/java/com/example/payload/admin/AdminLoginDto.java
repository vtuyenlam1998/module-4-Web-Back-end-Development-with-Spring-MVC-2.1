package com.example.payload.admin;

import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminLoginDto {
    private Long id;
    private String email;
    private String password;
}
