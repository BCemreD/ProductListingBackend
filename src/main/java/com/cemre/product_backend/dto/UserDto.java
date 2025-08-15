package com.cemre.product_backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
