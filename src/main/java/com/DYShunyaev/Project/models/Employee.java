package com.DYShunyaev.Project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

@Entity
@Data
//@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String name;

    @Column
    String surname;

    @Column
    String email;

    @Column
    Date birthday;

    @Column
    String address;

    @Column
    String department;

    @Column
    Date dateOfEmployment;
}
