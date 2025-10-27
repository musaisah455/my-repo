package com.code.myapp.rest;

import com.code.myapp.entity.UserDetail;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserRestController {

    // Using in-memory storage of a map and add values in its (key, value) pair
    private final Map<String, UserDetail> userDetailMap = new HashMap<>();

    {
        userDetailMap.put("pauling", new UserDetail("paul124", "paul", "saul", "number 24 estate", "paul@gmail.com"));
        userDetailMap.put("katering", new UserDetail("kate122", "kate", "solomon", "number 30 quarters", "kate@gmail.com"));
    }

    // Create user details
    @PostMapping("/users")
    public UserDetail addUserDetail(@RequestBody UserDetail theUser) {

        if (userDetailMap.containsKey(theUser.getUsername())) {
            throw new RuntimeException("Username already exist :");
        }

        userDetailMap.put(theUser.getUsername(), theUser);

        return theUser;
    }

    // Get user details by username
    @GetMapping("/users/{username}")
    public UserDetail getUserDetail(@PathVariable String username) {
           UserDetail userDetail = userDetailMap.get(username);

           if (userDetail == null) {
               throw new RuntimeException("User " + username + " not found :");
           }

           return userDetail;
    }

    // Get all user details
    @GetMapping("/users")
    public Iterable<UserDetail> getUserDetail() {
        return userDetailMap.values();
    }

    // Delete existing user details by username
    @DeleteMapping("/users/{username}")
    public Object deleteUser(@PathVariable String username) {
                UserDetail userDetail = userDetailMap.remove(username);
                if (userDetail == null) {
                    throw new RuntimeException("User details with username not found: " + username);
                }
                return  " " + username + " deleted successfully";
    }

    // Update existing user details by username
    @PutMapping("/users/{username}")

    public UserDetail updateUser(@PathVariable String username, @RequestBody UserDetail userDetails) {
        UserDetail theUser = userDetailMap.get(username);
        if (theUser == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        // Update all provided field in the request one-by-one
        if (userDetails.getUsername() != null) {
            theUser.setUsername(userDetails.getUsername());
        }

        if (userDetails.getFirstname() != null) {
            theUser.setFirstname(userDetails.getFirstname());
        }
        if (userDetails.getLastname() != null) {
            theUser.setLastname(userDetails.getLastname());
        }
        if (userDetails.getAddress() != null) {
            theUser.setAddress(userDetails.getAddress());
        }
        if (userDetails.getEmail() != null) {
            theUser.setEmail(userDetails.getEmail());
        }

        userDetailMap.put(username, theUser);
        return theUser;
    }
}