package L1;

import javax.management.RuntimeErrorException;

public class Task03 {
    public static void main(String[] args) {
        int[][] array = {{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},};
        int[][] array1 = {{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},};
        int[][] array2 = {{1,0,1,0,1},{1,0,8,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1}};
        System.out.println(summBinaryValue(array));
        System.out.println(summBinaryValue(array1));
        System.out.println(summBinaryValue(array2));
    }
    public static int summBinaryValue(int[][] array){

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != array[i].length) throw new RuntimeErrorException("Массив не квадратный(" + array.length +
                "x" + array[i].length + ")"); 
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) throw new RuntimeErrorException("Элемент с индексами -" + i +" "
                    + j + "имеет значение" + array[i][j]);
                sum += array[i][j];

            }  
        }
        return sum;
    }
    
    
}
