package com.metacube.metacafe.dto;

import com.metacube.metacafe.entity.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RoleDTO {
    
    private Integer id;

    private String name;

    private Integer priority;

    public RoleDTO(RoleEntity role) {
        this.id = role.getId();
        this.name = role.getName();
        this.priority = role.getPriority();
    }

}
