package org.web.bankingapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.web.bankingapp.converter.Converter;
import org.web.bankingapp.dto.UserCreateDto;
import org.web.bankingapp.dto.UserResponseDto;
import org.web.bankingapp.entity.User;
import org.web.bankingapp.security.AuthenticationService;
import org.web.bankingapp.security.model.JwtAuthenticationResponse;
import org.web.bankingapp.security.model.SignInRequest;
import org.web.bankingapp.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserCreateDto, UserResponseDto> createConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request){
        return authenticationService.authenticate(request);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll().stream()
                .map(user -> createConverter.toDto(user, userService.getCurrentUserRole()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return createConverter.toDto(userService.getById(id));
    }

    @GetMapping("/search")
    public UserResponseDto getUserByUsername(@RequestParam String username) {
        return createConverter.toDto(userService.getByUsername(username));
    }

    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserCreateDto userCreateDto) {
        User user = createConverter.toEntity(userCreateDto);
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return createConverter.toDto(userService.create(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
