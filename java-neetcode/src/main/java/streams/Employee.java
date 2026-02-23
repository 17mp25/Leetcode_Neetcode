package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
//         employees.forEach(System.out::println);
//        System.out.println("//////////////////////////////");
//        // Test: Filter employees with salary > 60000 and print them
//         employees.stream().filter(e->e.getSalary()>60000).forEach(System.out::println);
//        Set<Employee> collect = employees.stream().filter(e -> e.department == "IT").collect(Collectors.toSet());
//        System.out.println(collect);
        Set<String> collect = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println(collect);
        int sum = employees.stream().mapToInt(Employee::getSalary).sum();
        System.out.println(sum);
        Employee employee1 = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(employee1);
        Employee employee2 = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(employee2);
        List<String> list = employees.stream().map(Employee::getName).sorted().toList();
        System.out.println(list);
        List<String> list1 = employees.stream().map(Employee::getName).sorted(Comparator.reverseOrder()).toList();
        System.out.println(list1);
        Employee employee3 = employees.stream().filter(employee -> employee.getSalary() > 90000).findAny().orElse(null);
        System.out.println(employee3);

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