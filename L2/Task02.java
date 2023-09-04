package L2;

public class Task02 {
    public static void main(String[] args) {
        try {
            int d = 0;
            
            // Инициализируем массив с какими-то значениями
            int[] intArray = {1, 2, 3, 4, 5};
            
            // Выполняем деление, которое может вызвать ArithmeticException
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Обрабатываем исключение, если индекс массива выходит за его пределы
            System.out.println("Catching exception: " + e);
        } catch (ArithmeticException e) {
            // Обрабатываем исключение, если происходит деление на ноль
            System.out.println("Catching exception: " + e);
        }
    }
}