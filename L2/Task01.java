package L2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float userInput = getInput(scanner);
        System.out.println("Вы ввели: " + userInput);
        scanner.close();
    }

    public static float getInput(Scanner scanner) {
        float result = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print("Введите дробное число (типа float): ");
                result = scanner.nextFloat();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите корректное дробное число.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        } while (!validInput);

        return result;
    }
}