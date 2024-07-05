package org.example.huydq.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String studentCode;
    private Date dateOfBirth;
    private String address;
    private String phone;
    private String email;
}
