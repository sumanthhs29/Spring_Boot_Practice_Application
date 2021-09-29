package com.example.pooja_archana.dto.request;

import lombok.Data;

@Data
public class AddUserRequest {

    private String name;
    private String email;
    private String mobile;
    private String gender;
    private String dob;
    private String password;
}
