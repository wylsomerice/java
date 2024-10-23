import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Employee head;
    private List<Employee> employees;

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
        this.employees = new ArrayList<>();
        addEmployee(head);
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }
    public List<Employee> getEmployees() {
        return employees;
    }
}