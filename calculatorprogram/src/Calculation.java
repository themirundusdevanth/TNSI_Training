import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator Calculate = new Calculator();

            while (true){
                System.out.println("Choose an operation to be perform:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Divide");
                System.out.println("5. Exit Program");

                int choice = scanner.nextInt();

                System.out.println("Enter first number:");
                int number1 = scanner.nextInt();

                System.out.println("Enter Second Number:");
                int number2 = scanner.nextInt();

                int result = 0;

                switch (choice) {
                    case 1:
                        result = Calculate.add(number1, number2);
                        break;
                    case 2:
                        result = Calculate.subtract(number1, number2);
                        break;
                    case 3:
                        result = Calculate.multiply(number1, number2);
                        break;
                    case 4:
                        result = Calculate.divide(number1, number2);
                        break;
                    case 5:
                        System.out.println("Excited");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                System.out.println("Result: "+ result);

            }
        }
    }
}
