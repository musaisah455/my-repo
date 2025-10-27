package com.code.myapp2.rest;

import com.code.myapp2.entity.UserDetail;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserRestController {

    private final Map<String, UserDetail> userDetailMap = new HashMap<>();

    {
        userDetailMap.put("pauling", new UserDetail("paul124", "paul", "saul", "number 24 estate", "paul@gmail.com"));
        userDetailMap.put("katering", new UserDetail("kate122", "kate", "solomon", "number 30 quarters", "kate@gmail.com"));
    }

    @PostMapping("/users")
    public UserDetail addUserDetail(@RequestBody UserDetail theUser) {

        if (userDetailMap.containsKey(theUser.getUsername())) {
            throw new RuntimeException("Username already exist :");
        }

        userDetailMap.put(theUser.getUsername(), theUser);

        return theUser;
    }

    @GetMapping("/users/{username}")
    public UserDetail getUserDetail(@PathVariable String username) {
        UserDetail userDetail = userDetailMap.get(username);

        if (userDetail == null) {
            throw new RuntimeException("User " + username + " not found :");
        }

        return userDetail;
    }

    @GetMapping("/users")
    public Iterable<UserDetail> getUserDetail() {
        return userDetailMap.values();
    }

    @DeleteMapping("/users/{username}")
    public Object deleteUser(@PathVariable String username) {
        UserDetail userDetail = userDetailMap.remove(username);
        if (userDetail == null) {
            throw new RuntimeException("User details with username not found :" + username);
        }
        return  " " + username + " deleted successfully";
    }

    @PutMapping("/users/{username}")

    public UserDetail updateUser(@PathVariable String username, @RequestBody UserDetail userDetails) {
        UserDetail existingUser = userDetailMap.get(username);
        if (existingUser == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        // Update fields if they are provided in the request
        if (userDetails.getUsername() != null) {
            existingUser.setUsername(userDetails.getUsername());
        }

        if (userDetails.getFirstname() != null) {
            existingUser.setFirstname(userDetails.getFirstname());
        }
        if (userDetails.getLastname() != null) {
            existingUser.setLastname(userDetails.getLastname());
        }
        if (userDetails.getAddress() != null) {
            existingUser.setAddress(userDetails.getAddress());
        }
        if (userDetails.getEmail() != null) {
            existingUser.setEmail(userDetails.getEmail());
        }

        // Note: We don't allow changing the username as it's our key
        userDetailMap.put(username, existingUser);
        return existingUser;
    }
}
