package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    public List<User> fetchAllUser(){
        return userList;
    }
    Long id = 1L;
    public void addUser(User user){
        user.setId(id++);
        userList.add(user);
    }
    public Optional<User> fetchUser(Long id){
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        }

}
