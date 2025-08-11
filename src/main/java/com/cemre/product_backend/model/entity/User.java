package com.cemre.product_backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer userId;

        @NotBlank
        @Column(name = "first_name")
        private String firstName;

        @NotBlank
        @Column(name = "last_name")
        private String lastName;

        @NotBlank
        private String password;

}
