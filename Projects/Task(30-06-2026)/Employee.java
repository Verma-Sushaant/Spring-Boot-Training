public class Employee {
    private int id;
    private String name;
    private int age;
    private Designations designation;
    private double salary;

    public Employee() {}
    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        switch(designation.toLowerCase()) {
            case "programmer" -> {
                this.designation = Designations.PROGRAMMER;
                this.salary = 25000.0;
            }
            case "manager" -> {
                this.designation = Designations.MANAGER;
                this.salary = 30000.0;
            }
            case "tester" -> {
                this.designation = Designations.TESTER;
                this.salary = 20000.0;
            }
        }
    }

    @Override
    public String toString() {
        return "Name: "+name+" Age: "+age+"\nDesignation: "+designation+" Salary: "+salary;
    }
    
    public int getId() { return id; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public Designations getDesignation() { return designation; }
    public double getSalary() { return salary; }

    public void setId(int id) { this.id = id; }
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setDesignation(Designations designation) { this.designation = designation; }
    public void setSalary(double salary) { this.salary = salary; }

    public void raiseSalary(double increase) {
        this.salary += salary*(increase/100);
    }
}