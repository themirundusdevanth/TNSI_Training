import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Employee {
    private String name;
    private LocalDate birthDate;
    private double basicSalary;

    public Employee(String name, LocalDate birthDate, double basicSalary) {
        this.name = name;
        this.birthDate = birthDate;
        this.basicSalary = basicSalary;
    }

    public int calculateAge() {
        LocalDate today = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDate, today);
    }

    public double calculateDearnessAllowance() {
        return 0.02 * basicSalary;
    }

    public double calculateTravellingAllowance() {
        return 0.01 * basicSalary;
    }

    public double calculateHouseRentAllowance() {
        return 0.03 * basicSalary;
    }

    public double calculateProvidentFund() {
        return 0.005 * basicSalary;
    }

    public double calculateGrossSalary() {
        return basicSalary + calculateDearnessAllowance() + calculateTravellingAllowance() + calculateHouseRentAllowance();
    }

    public double calculateTotalDeductions() {
        double totalDeductions = calculateProvidentFund();

        if (calculateGrossSalary() > 10000) {
            totalDeductions += 1000;
        }

        return totalDeductions;
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTotalDeductions();
    }

    public LocalDate calculateRetirementDate() {
        LocalDate today = LocalDate.now();
        return today.plusYears(55 - calculateAge());
    }

    public void displaySalaryDetails() {
        if (calculateAge() < 21 || calculateAge() > 60) {
            System.out.println("Invalid age. Age should be between 21 and 60.");
            return;
        }
        
        if (basicSalary < 4500 || basicSalary > 6500) {
            System.out.println("Invalid salary. Salary should be between 4500 and 6500.");
            return; 
        }

        System.out.println("\nEmployee Name: " + name);
        System.out.println("Age: " + calculateAge());
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Dearness Allowance: " + calculateDearnessAllowance());
        System.out.println("Travelling Allowance: " + calculateTravellingAllowance());
        System.out.println("House Rent Allowance: " + calculateHouseRentAllowance());
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("Provident Fund: " + calculateProvidentFund());
        System.out.println("Total Deductions: " + calculateTotalDeductions());
        System.out.println("Net Salary: " + calculateNetSalary());
        System.out.println("Retirement Date: " + calculateRetirementDate());
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee birth year (yyyy): ");
        int birthYear = scanner.nextInt();

        LocalDate birthDate = LocalDate.of(birthYear, 1, 1); 

        int age = new Employee(name, birthDate, 0).calculateAge(); 

        if (age < 21 || age > 60) {
            System.out.println("Invalid age. Age should be between 21 and 60.");
            return; 
        }

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        Employee employee = new Employee(name, birthDate, basicSalary);
        employee.displaySalaryDetails();
        }
    }
}
