package com.metacube.metacafe.dto;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.metacube.metacafe.entity.RoleEntity;
import com.metacube.metacafe.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean status;
    private Set<RoleDTO> roles;
    private String password;

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.roles = user.getRoles().stream().map(RoleDTO::new).collect(Collectors.toSet());
    }

    public UserEntity convertToEntity() {
        Set<RoleEntity> rolesEntitySet = this.getRoles().stream()
                .map(roleDto -> RoleEntity.builder().id(roleDto.getId()).name(roleDto.getName())
                        .priority(roleDto.getPriority()).build())
                .collect(Collectors.toSet());

        return UserEntity.builder().id(this.id).firstName(this.firstName).lastName(this.lastName)
                .email(this.email).username(email).status(true)
                .password(new BCryptPasswordEncoder().encode(this.password)).roles(rolesEntitySet).build();
    }
}
