package koza.dev.traveltogbackend.controller.auth;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
