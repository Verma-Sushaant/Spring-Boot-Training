import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class EmployeeRepo {
    private final List<Employee> employees = new ArrayList<>();
    private int id = 0;

    public void save(Employee employee) {
        employee.setId(++id);
        employees.add(employee);
    }
    public String findAll() {
        return employees.stream()
                    .map(Employee::toString)
                    .collect(Collectors.joining("\n"));
    }
    public Employee findById(int id) {
        for(Employee e: employees) {
            if(e.getId() == id) return e;
        }
        return null;
    }
}