package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        Set<String> collect = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
//        System.out.println(collect);
//        int sum = employees.stream().mapToInt(Employee::getSalary).sum();
//        System.out.println(sum);
//        Employee employee1 = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
//        System.out.println(employee1);
//        Employee employee2 = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
//        System.out.println(employee2);
//        List<String> list = employees.stream().map(Employee::getName).sorted().toList();
//        System.out.println(list);
//        List<String> list1 = employees.stream().map(Employee::getName).sorted(Comparator.reverseOrder()).toList();
//        System.out.println(list1);
//        Employee employee3 = employees.stream().filter(employee -> employee.getSalary() > 90000).findAny().orElse(null);
//        System.out.println(employee3);
        List<String> collect = employees.stream().filter(e -> e.isActive())
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(collect);

        OptionalDouble average = employees.stream().mapToInt(Employee::getSalary).average();
        System.out.println(average.orElse(0.0));

        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingInt(Employee::getSalary)));
        System.out.println(collect1);

        Map<String, List<Employee>> collect2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect2);

        Map<String, Long> collect3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect3);

        Map<String, Optional<Employee>> collect4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(collect4);

        List<Employee> list = employees.stream().filter(e -> e.city == "New York" && e.getSalary() > 60000).toList();
        System.out.println(list);

        Map<Boolean, List<String>> collect5 = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 60000,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(collect5);

        Set<Character> set = Set.of('a','e','i','o','u');
        List<Employee> list1 = employees.stream()
                .filter(employee -> set.contains(Character.toLowerCase(employee.getName().charAt(0)))).toList();
        System.out.println(list1);

        Map<String, Integer> collect6 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingInt(Employee::getSalary)));
        System.out.println(collect6);

        List<Integer> list2 = employees.stream().flatMap(employee -> employee.getBankBalance().stream()).toList();
        System.out.println(list2);

        employees.stream().collect(Collectors.groupingBy())
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