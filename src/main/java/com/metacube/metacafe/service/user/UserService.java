package com.metacube.metacafe.service.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.metacube.metacafe.dto.UserDTO;
import com.metacube.metacafe.models.AddUserRequest;

public interface UserService extends UserDetailsService {

    public List<UserDTO> findAll();

    public UserDTO addUser(AddUserRequest addUserRequest);

    public void deleteUser(Integer id);

}
