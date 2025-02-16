package com.kafka.user_service.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private String email;
    private String password;

}
