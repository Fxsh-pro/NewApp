package com.backend.zlpfinpd.service;

import com.backend.zlpfinpd.model.dto.UserDto;
import com.backend.zlpfinpd.model.dto.UserRegisterRequest;
import com.backend.zlpfinpd.model.entity.User;
import com.backend.zlpfinpd.repository.UserRepository;
import com.backend.zlpfinpd.utils.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    public UserDto createUser(UserRegisterRequest userDto) {
        User user = userMapper.toEntity(userDto);
        System.out.println(user);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }


//    public UserDto updateUser(Long userId, UserDto userDto) {
//        User existingUser = userRepository.findById(userId)
//                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//        User updatedUser = userMapper.toEntity(userDto);
//        updatedUser.setId(existingUser.getId());
//        User savedUser = userRepository.save(updatedUser);
//        return userMapper.toDto(savedUser);
//    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
