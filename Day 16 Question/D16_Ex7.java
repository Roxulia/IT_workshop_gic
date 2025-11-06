import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee7{
    private String name;
    private int age;
    private String department;

    public Employee7(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
    
    public String getName()
    {
        return name;
    }
}

public class D16_Ex7 {

    public static void main(String[] args) {
        List<Employee7> employees = Arrays.asList(
            new Employee7("Alice", 30, "HR"),
            new Employee7("Bob", 25, "IT"),
            new Employee7("Charlie", 35, "HR"));

         Map<String, Long> departmentCount = employees.stream()
            .collect(Collectors.groupingBy(Employee7::getDepartment,
 Collectors.counting()));
        System.out.println(departmentCount);
    }
}
