package com.example.payload.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginDto {
    private Long id;
    private String email;
    private String password;
}
