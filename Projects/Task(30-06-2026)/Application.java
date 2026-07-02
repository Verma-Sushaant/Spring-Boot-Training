import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        EmployeeRepo repo = new EmployeeRepo();
        EmployeeService employeeService = new EmployeeService(repo);

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
                        int age = -1;
                        while(age == -1 || age < 18 || age > 60) {
                            System.out.println("Enter Age: ");
                            age = obj.nextInt();
                            obj.nextLine();
                        }
                        String designation = null;
                        while(designation == null) {
                            System.out.println("Designations: ");
                            System.out.println("1. Programmer\n2. Manager\n3. Tester");
                            System.out.println("Enter designation: ");
                            String desg = obj.nextLine();
                            switch(desg.toLowerCase()) {
                                case "1", "programmer" -> designation = "programmer";
                                case "2", "manager" -> designation = "manager";
                                case "3", "tester" -> designation = "tester";
                                default -> System.out.println("Please select from the given options!");
                            }
                        }

                        employeeService.addEmployee(name, age, designation);

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
                    int id = obj.nextInt();
                    double incInSalary = -1;
                    while(incInSalary == -1 || incInSalary < 1 || incInSalary > 10) {
                        System.out.println("Enter increase in salary(1-10%): ");
                        incInSalary = obj.nextDouble();
                        obj.nextLine();
                    }

                    System.out.println(employeeService.updateSalary(id, incInSalary));
                }
                case "4", "exit" -> {
                    System.out.println("Thank you for using our application");
                    obj.close();
                    System.exit(0);
                }
                default -> 
                    System.out.println("!!Invalid choice!!");
            }
        }
    }
}