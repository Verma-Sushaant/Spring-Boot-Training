package com.example.Task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Pattern(
        regexp="^[A-Za-z]+(\\s[A-Za-z]+){0,2}$",
        message="Name can only be of letters and at max 2 spaces.")
    @NotBlank(message="Name should not be blank")
    private String name;
    /*@Pattern(
        regexp="^[0-9]+$",
        message="Age can only consists of numbers")*/
    @Min(value=18,message="Age must be greater than 17.")
    @Max(value=60,message="Age must be less than 61.")
    private Integer age;
    private Double salary;
    private String designation;

    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        switch(designation.toLowerCase()) {
            case "programmer" -> this.salary = 25000.0;
            case "manager" -> this.salary = 30000.0;
            case "tester" -> this.salary = 20000.0;
        }
    }
}
