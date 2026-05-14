package com.app.ecom.service;

import com.app.ecom.dto.AddressDTO;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.model.User;
import com.app.ecom.model.UserRole;
import com.app.ecom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

@Service
public class UserService {
    private final UserRepository userRepository;
    //private List<User> userList = new ArrayList<>();



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> fetchAllUser(){
        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }



    public void addUser(UserRequest userRequest){

        User user = new User();
        updateUserFromRequest(user,userRequest);
        userRepository.save(user);
    }
    public Optional<UserResponse> fetchUser(Long id){
        return userRepository.findById(id);

        }

    public boolean updateUser(Long id, UserRequest updatedUser) {
        return userRepository.findById(id)
                .map(existingUser ->{ existingUser.setFirstName(updatedUser.getFirstName());
                        existingUser.setLastName(updatedUser.getLastName());
                        userRepository.save(existingUser);
                          return true;}).orElse(false);

    }

    private void updateUserFromRequest(User user , UserRequest userRequest){
    if(user.getRole()==null){
        user.setRole(UserRole.CUSTOMER);
    }
    user.setFirstName(user.getFirstName());
    user.setLastName(user.getLastName());
    user.setEmail(user.getEmail());
    user.setPhone(user.getPhone());
    if(user.getAddress()!=null){
        Address address = new Address();
        address.setStreet(userRequest.getAddressDTO().getStreet());
        address.setState(userRequest.getAddressDTO().getState());
        address.setCity(userRequest.getAddressDTO().getCity());
        address.setZipcode(userRequest.getAddressDTO().getZipcode());
        address.setCountry(userRequest.getAddressDTO().getCountry());
    }
    }
}

    private UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());

        if(user.getAddress()!=null){
            AddressDTO addressDto = new AddressDTO();
            addressDto.setStreet(addressDto.getStreet());
            addressDto.setCity(addressDto.getCity());
            addressDto.setState(addressDto.getState());
            addressDto.setZipcode(addressDto.getZipcode());
            response.setAddressDTO(addressDto);
        }

    }


