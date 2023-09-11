import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine().trim();

        try {
            String[] userData = input.split("\\s+");
            if (userData.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных. Введите все данные.");
            }

            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDate = userData[3];
            String phoneNumber = userData[4];
            String gender = userData[5];

            validateData(lastName, firstName, middleName, birthDate, phoneNumber, gender);

            String filename = lastName + ".txt";
            String record = lastName + firstName + middleName + birthDate + " " + phoneNumber + gender;

            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(record + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IllegalArgumentException | DataFormatException | IOException e) {
            e.printStackTrace();
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void validateData(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) throws DataFormatException {
        if (!Pattern.matches("[a-zA-Za-яА-Я]+", lastName)
                || !Pattern.matches("[a-zA-Za-яА-Я]+", firstName)
                || !Pattern.matches("[a-zA-Za-яА-Я]+", middleName)) {
            throw new DataFormatException("Неверный формат ФИО.");
        }

        if (!Pattern.matches("\\d{2}\\.\\d{2}\\.\\d{4}", birthDate)) {
            throw new DataFormatException("Неверный формат даты рождения. Используйте dd.mm.yyyy.");
        }

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new DataFormatException("Неверный формат номера телефона.");
        }

        if (!gender.equals("f") && !gender.equals("m")) {
            throw new DataFormatException("Неверный формат пола. Используйте 'f' или 'm'.");
        }
    }

    private static class DataFormatException extends Exception {
        public DataFormatException(String message) {
            super(message);
        }
    }
}