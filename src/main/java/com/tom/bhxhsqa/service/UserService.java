package com.tom.bhxhsqa.service;

import com.tom.bhxhsqa.dto.UserDTO;
import com.tom.bhxhsqa.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    public UserDTO getCurrentUser(Long id);

    public void save(User user);

    public boolean login(String username, String password);
}
