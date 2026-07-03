class Employee {
    private final int employeeId;
    private final String name;
    private final String position;
    private final double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return employeeId + " - " + name + ", " + position + ", salary=" + salary;
    }
}

class EmployeeDirectory {
    private final Employee[] employees;
    private int size;

    EmployeeDirectory(int capacity) {
        employees = new Employee[capacity];
    }

    boolean add(Employee employee) {
        if (size == employees.length) {
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    Employee search(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    boolean delete(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }

    void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory(5);
        directory.add(new Employee(1, "Anika", "Developer", 65000));
        directory.add(new Employee(2, "Vikram", "Tester", 52000));
        directory.add(new Employee(3, "Neha", "Manager", 85000));

        System.out.println("Search result: " + directory.search(2));
        directory.delete(1);
        directory.traverse();
    }
}

