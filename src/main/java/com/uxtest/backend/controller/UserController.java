package com.uxtest.backend.controller;

import com.uxtest.backend.dto.UserDTO;
import com.uxtest.backend.model.user.User;
import com.uxtest.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id).mapToDTO();
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(User::mapToDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO.parseUser());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userService.updateUser(userDTO.parseUser(), id);
    }
}
