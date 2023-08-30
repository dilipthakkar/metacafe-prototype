package com.metacube.metacafe.models;

import org.springframework.security.core.GrantedAuthority;

import com.metacube.metacafe.entity.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Role implements GrantedAuthority{

    private Integer roleId;

    private String roleName;

    private Integer priority;

    public Role(RoleEntity roleEntity){
        this.roleId = roleEntity.getId();
        this.roleName = roleEntity.getName();
        this.priority = roleEntity.getPriority();
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + roleName;
    }
    
}
