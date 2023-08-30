package com.metacube.metacafe.service.user;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.metacafe.dto.UserDTO;
import com.metacube.metacafe.entity.RoleEntity;
import com.metacube.metacafe.entity.UserEntity;
import com.metacube.metacafe.models.AddUserRequest;
import com.metacube.metacafe.models.User;
import com.metacube.metacafe.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public List<UserDTO> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).map(User::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        return user;
    }

    @Override
    @Transactional
    public UserDTO addUser(AddUserRequest addUserRequest) {
        UserEntity userEntity = addUserRequest.getUser().convertToEntity();
        userEntity = userRepository.save(userEntity);
        return new UserDTO(userEntity);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        UserEntity userToBeDelete = UserEntity.builder().id(id).build();
        userRepository.delete(userToBeDelete);
    }
}
