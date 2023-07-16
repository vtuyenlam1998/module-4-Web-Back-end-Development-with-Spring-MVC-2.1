package com.example.service.user;

import com.example.model.Role;
import com.example.payload.user.RoleDto;
import com.example.payload.user.UserDto;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<UserDto> findAll() {
        Iterable<User> entities = userRepository.findAll();
        return StreamSupport.stream(entities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return Optional.of(modelMapper.map(user, UserDto.class));
    }

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        if (!userDto.getPassword().isEmpty()) {
            String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10));
            user.setPassword(hashedPassword);
        }
        user.setActivated(true);
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public void softDelete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserDto> findAllByRole(RoleDto roleDto) {
        Iterable<User> entities = userRepository.findAllByRole(roleDto);
        return StreamSupport.stream(entities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        List<User> entities = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>(
                entities.stream()
                        .parallel()
                        .map(entity -> modelMapper.map(entity, UserDto.class))
                        .collect(Collectors.toList()));
        return new PageImpl<>(dtos);
    }

    @Override
    public Page<UserDto> findAllByFullNameContaining(String fullName, Pageable pageable) {
        Page<User> entities = userRepository.findAllByFullNameContaining(fullName, pageable);
        List<UserDto> dtos = new ArrayList<>(
                entities.stream()
                        .parallel()
                        .map(entity -> modelMapper.map(entity, UserDto.class))
                        .collect(Collectors.toList()));
        return new PageImpl<>(dtos);
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null
                || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}