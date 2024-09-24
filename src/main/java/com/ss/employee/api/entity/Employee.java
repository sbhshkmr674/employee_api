package com.ss.employee.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="Employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="department")
    private String dept;

    @Column(name="designation")
    private String designation;

















}
