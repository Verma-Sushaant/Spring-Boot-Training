package com.example.Task;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Task.Entity.Employee;
import com.example.Task.Repository.EmployeeRepo;
import com.example.Task.Service.EmployeeService;

@Component
public class ConsoleEmployeeInput implements CommandLineRunner {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) {
        Scanner obj = new Scanner(System.in);

        while(true) {
            System.out.println("\n================================");
            System.out.println("1) CREATE\n2) DISPLAY\n3) RAISE SALARY\n4) EXIT");
            System.out.println("Enter your choice: ");
            String choice = obj.nextLine();
            switch(choice.toLowerCase()) {
                case "1", "create" -> {
                    while(true) {
                        System.out.println("Enter Name: ");
                        String name = obj.nextLine();
                        System.out.println("Enter Age: ");
                        int age = obj.nextInt();
                        obj.nextLine();
                        System.out.println("Enter Designation: ");
                        String designation = obj.nextLine();

                        employeeRepo.save(new Employee(name, age, designation));

                        System.out.println("Add another employee(Y/N): ");
                        String ans = obj.nextLine();
                        if(ans.equalsIgnoreCase("N")) break;
                    }
                }
                case "2", "display" -> 
                    // employeeRepo.findAll().forEach(System.out::println);
                    System.out.println(employeeService.getAllEmployees());
                case "3", "raise salary" -> {
                    System.out.println("Enter id: ");
                    long id = obj.nextLong();
                    System.out.println("Enter increase in salary(%): ");
                    double incInSalary = obj.nextDouble();
                    obj.nextLine();
                    System.out.println(employeeService.updateSalary(id, incInSalary));
                }
                case "4", "exit" -> {
                    System.out.println("Exiting...");
                    obj.close();
                    System.exit(0);
                }
                default -> 
                    System.out.println("!!Invalid choice!!");
            }
        }
    }
}
