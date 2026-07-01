public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public void addEmployee(String name, int age, String designation) {
        Employee employee = new Employee(name,age, designation);
        employeeRepo.save(employee);
    }
    public String getAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }
    public String updateSalary(int id, double percent) {
        Employee employee = employeeRepo.findById(id);
        if(employee != null) {
            employee.raiseSalary(percent);
            return "Salary updated for "+employee.getName();
        }
        else {
            return "Employee with id "+id+" not found";
        }
    }
}