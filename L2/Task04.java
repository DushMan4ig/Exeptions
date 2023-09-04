package L2;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Пустые строки вводить нельзя в Java");
            }

            System.out.println("Вы ввели: " + input);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}