package com.example.exerciserepository.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty
    @Size(min = 5)
    // @Column(columnDefinition = "varchar(20) not null")
    private String name ;

    @NotEmpty
    @Size(min = 5)
    // @Column(columnDefinition = "varchar(20) not null unique")
    private String userName ;

    @NotEmpty
    // @Column(columnDefinition = " varchar(10) not null")
    private String password ;

    @NotEmpty
    @Email
    //  @Column(columnDefinition = " varchar(40) not null unique ")
    private String email;


    // @Column(columnDefinition = " int not null")
    @NotNull
    @Digits(integer = 10 ,fraction = 0)
    private Integer age;

    @NotEmpty
    @Pattern(regexp ="^(user|admin)$")
    // @Column(columnDefinition = "varchar(10) not null check role='user' or role='admin')")
    private String role;

}
