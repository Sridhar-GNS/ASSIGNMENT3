package com.example.assignment3.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    int user_id;
    String user_name;
    String password;
    Double latitude;
    Double longitude;

}
