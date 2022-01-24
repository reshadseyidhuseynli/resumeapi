package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name="name",required = false) String name,
            @RequestParam(name="surname",required = false) String surname){
        List<User> users = userService.searchingUsers(name,surname);

        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i < users.size(); i++){
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }

        return ResponseEntity.ok(ResponseDTO.createResponse(userDTOS));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id){
        User user = userService.getUserByID(id);

        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(ResponseDTO.createResponse(userDTO));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id){
        User user = userService.getUserByID(id);
        userService.delete(id);

        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(ResponseDTO.createResponse(userDTO, "Successfully Deleted"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO u){
        User user = new User();
        user.setName(u.getName());
        user.setSurname(u.getSurname());
        user.setPassword(u.getPassword());
        userService.addUser(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPassword(user.getPassword());
        return ResponseEntity.ok(ResponseDTO.createResponse(userDTO, "Successfully Added"));
    }
}
