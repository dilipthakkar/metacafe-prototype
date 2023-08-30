package com.metacube.metacafe.models;

import com.metacube.metacafe.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddUserRequest {
    private UserDTO user;
}
