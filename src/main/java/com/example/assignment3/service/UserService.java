package com.example.assignment3.service;

import com.example.assignment3.User;

import java.io.UnsupportedEncodingException;

public interface UserService {

    User registerUser(int user_id, String user_name, String address, Double latitude, Double longitude) throws UnsupportedEncodingException;

    Boolean enrollForOfflinePayment(int user_id);


    String generateUserSecret();
    public User approveUser(int user_id);
}
