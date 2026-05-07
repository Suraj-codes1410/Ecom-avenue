package com.app.ecom;


 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private  UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    private List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllusers(){
        return new ResponseEntity<>(userService.fetchAllUser(),
                HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User>  getUser(@PathVariable Long id){
//        User user = userService.fetchUser(id);
//        if(user == null)
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(user);

        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/users/updateInfo/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id
    ,@RequestBody User updatedUser){
     boolean updated = userService.updateUser(id,updatedUser);
     if(updated)
         return new ResponseEntity<>("User Updated Successfully",HttpStatus.OK);
     return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/users")
     public ResponseEntity<String> createUser(@RequestBody User user){
         userService.addUser(user) ;
         return new ResponseEntity<>("User added Successfully",HttpStatus.OK);
    }

}
