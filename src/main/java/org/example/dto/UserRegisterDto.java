package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRegisterDto {

    private String username;
    private String password;
    private String passwordConfirm;

}
