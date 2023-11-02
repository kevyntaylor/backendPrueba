package com.example.pruebaamaris.domain;

import lombok.Data;

@Data
public class EmpleadoDTO {
    private Long id;
    private String employee_name;
    private Double employee_salary;
    private Integer employee_age;
    private String profile_image;
    private Double anualSalary;
}
