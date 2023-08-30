package com.metacube.metacafe.models;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.metacube.metacafe.entity.UserEntity;

public class User implements UserDetails{

    private String userName;
    private String password;
    private Boolean status;
    private Set<GrantedAuthority> authorities;

    public User(UserEntity userEntity){
        this.userName = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.authorities = userEntity.getRoles().stream().map(Role::new).collect(Collectors.toSet());
        this.status = userEntity.getStatus();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status;
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }
    
}
