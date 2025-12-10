package com.code.myapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDetail {

    private String username;
    private String firstname;
    private String lastname;
    private String address;
    private String email;

}

