package com.example.payload.user;

import com.example.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    private Long id;
    private Role role;
    private String fullName;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 50, message = "Số lượng từ trong 5-50")
    private String username;
    @Size(min = 5, message = "Số lượng chữ tối thiểu là 5")
    @NotBlank(message = "Không được để trống")
    private String password;
    @Email(message = "định dạng email,phải có @")
    private String email;
    private String address;
    private String phone;
    private String avatar;
    private Boolean activated;
    private String rememberToken;

    public UserDto() {
    }

    public UserDto(Long id, Role role, String fullName, String username,
                   String password, String email, String address, String phone,
                   String avatar, Boolean activated, String rememberToken) {
        super();
        this.id = id;
        this.role = role;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.activated = activated;
        this.rememberToken = rememberToken;
    }

    public UserDto(Role role, String fullName, String username, String password,
                   String email, String address, String phone, String avatar,
                   Boolean activated, String rememberToken) {
        super();
        this.role = role;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        this.activated = activated;
        this.rememberToken = rememberToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
}