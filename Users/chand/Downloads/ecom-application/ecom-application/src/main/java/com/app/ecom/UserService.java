package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.spi.ToolProvider.findFirst;

@Service
public class UserService {
    private final UserRepository userRepository;
    //private List<User> userList = new ArrayList<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUser(){
        return userRepository.findAll();
    }
    Long id = 1L;
    public void addUser(User user){
        userRepository.save(user);
    }
    public Optional<User> fetchUser(Long id){
        return userRepository.findById(id);
        }

    public boolean updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser ->{ existingUser.setFirstName(updatedUser.getFirstName());
                        existingUser.setLastName(updatedUser.getLastName());
                        userRepository.save(existingUser);
                          return true;}).orElse(false);

    }

    }


