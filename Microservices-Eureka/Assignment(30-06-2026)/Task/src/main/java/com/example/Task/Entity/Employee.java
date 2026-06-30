package com.example.Task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String designation;
    private Double salary;

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

    public void raiseSalary(double incInSalary) {
        this.salary += salary*(incInSalary/100);
    }
}