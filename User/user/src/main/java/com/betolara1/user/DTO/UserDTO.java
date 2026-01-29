package com.betolara1.user.DTO;

import com.betolara1.user.model.User;

import lombok.Data;

@Data
public class UserDTO {

    private String userName;
    private String name;
    private String email;
    private String phone;
    private String address;

    public UserDTO(){}

    public UserDTO(User user){
        this.userName = user.getUserName();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }

}