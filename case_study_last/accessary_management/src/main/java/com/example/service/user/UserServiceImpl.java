package com.example.service.user;

import com.example.dto.user.UserLoginDto;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void softDelete(Long id) {
        userRepository.updateByIsActiveFalse(id);
    }

    @Override
    public List<UserLoginDto> findAllByEmailAndPassword() {
        List<User> users = (List<User>) userRepository.findAllByIsActiveTrue();
        return users.stream().map(entity -> modelMapper.map(entity, UserLoginDto.class)).collect(Collectors.toList());
    }
}
