package streams;

import java.util.Arrays;
import java.util.List;

public class Employee {
    int id;
    String name;
    String department;
    int salary;
    String city;
    List<Integer> bankBalance;
    boolean active;

    // Constructor
    public Employee(int id, String name, String department, int salary,
                    String city, List<Integer> bankBalance, boolean active)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.city = city;
        this.bankBalance = bankBalance;
        this.active = active;
    }

    // Main method or you can create a separate class to use this
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 50000, "New York", Arrays.asList(1000, 2000, 3000), true),
                new Employee(2, "Bob", "HR", 60000, "Chicago", Arrays.asList(1500, 2500, 3500), true),
                new Employee(3, "Charlie", "IT", 55000, "San Francisco", Arrays.asList(1200, 2200, 3200), false),
                new Employee(4, "David", "Finance", 70000, "New York", Arrays.asList(2000, 3000, 4000), true),
                new Employee(5, "Eve", "HR", 65000, "Chicago", Arrays.asList(1800, 2800, 3800), false)
        );

        // Test: Print all employees
        employees.forEach(System.out::println);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public List<Integer> getBankBalance() {
        return bankBalance;
    }

    public boolean isActive() {
        return active;
    }

    // Optional: toString for debugging
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", bankBalance=" + bankBalance +
                ", active=" + active +
                '}';
    }


}