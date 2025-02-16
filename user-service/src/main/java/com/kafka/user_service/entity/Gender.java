package com.kafka.user_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="gender")
public class Gender {

    @Id
    private int id;
    private String gender;
}
