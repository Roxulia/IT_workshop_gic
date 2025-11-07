
import java.util.*;

class Employee167{

    private int yearOfExperience;
    private double salary;

    public Employee167(int yearOfExperience, double salary) {
        this.yearOfExperience = yearOfExperience;
        this.salary = salary;
    }
    
    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public double getSalary() {
        return salary;
    }
}

public class D17_Ex7 {

    public static double calculateAverageSalary_A(List<Employee167> employees) { return employees.stream() .filter(e -> e.getYearOfExperience() >= 2) .mapToDouble(Employee167::getSalary) .average() .orElse(0.0); }
    public static double calculateAverageSalary_B(List<Employee167> employees) { return employees.stream() .filter(e -> e.getYearOfExperience() >= 2) .map(Employee167::getSalary)  .reduce(0.0, Double::sum) / employees.size();}
    public static double calculateAverageSalary_C(List<Employee167> employees) { double sum = 0.0; int count = 0; for (Employee167 e : employees) { if (e.getYearOfExperience() >= 2) { sum += e.getSalary(); count++; } } return count > 0 ? sum / count : 0.0; }
    public static double calculateAverageSalary_D(List<Employee167> employees) { return employees.parallelStream() .filter(e -> e.getYearOfExperience() >= 2) .mapToDouble(Employee167::getSalary) .sum() / employees.size(); }

    public static void main(String[] args) {
        List<Employee167> employees = Arrays.asList(
            new Employee167(5, 100000),
            new Employee167(2, 75000),
            new Employee167(0, 50000),
            new Employee167(3, 85000)
        );

        double avg = calculateAverageSalary_A(employees);
        avg = calculateAverageSalary_B(employees);
        avg = calculateAverageSalary_C(employees);
        avg = calculateAverageSalary_D(employees);

        long startTime = System.nanoTime();

        avg = calculateAverageSalary_A(employees);
        System.out.println("Tessting A Result .....");

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        avg = calculateAverageSalary_B(employees);
        System.out.println("Tessting B Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+avg);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        avg = calculateAverageSalary_C(employees);
        System.out.println("Tessting C Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+avg);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        avg = calculateAverageSalary_D(employees);
        System.out.println("Tessting D Result .....");
        System.out.println("Actual Res : 150 | Tested Res : "+avg);
        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();
        avg = calculateAverageSalary_A(employees);
        System.out.println("Tessting A Result .....");
        System.out.println("Actual Res : 86666.67 | Tested Res : "+avg);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        avg = calculateAverageSalary_B(employees);
        System.out.println("Tessting B Result .....");
        System.out.println("Actual Res : 86666.67 | Tested Res : "+avg);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        avg = calculateAverageSalary_C(employees);
        System.out.println("Tessting C Result .....");
        System.out.println("Actual Res : 86666.67 | Tested Res : "+avg);

        System.out.println("Time taken : "+ (System.nanoTime()-startTime));

        startTime = System.nanoTime();

        avg = calculateAverageSalary_D(employees);
        System.out.println("Tessting D Result .....");
        System.out.println("Actual Res : 86666.67 | Tested Res : "+avg);
        System.out.println("Time taken : "+ (System.nanoTime()-startTime));
    }
}
