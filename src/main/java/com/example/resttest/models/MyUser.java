package com.example.resttest.models;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
public class MyUser {
    @Id
    @Column(name = "id")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY , description = "это поле генерируется автоматически")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    public MyUser(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
