package L1;
public class Task01{
    public static void main(String[] args) {
    int[] array = {1, 2 ,3, 4, 5, 6};
    System.out.println(checkArray(array, 7));
    System.out.println(checkArray(array, 3));
}
public static int checkArray(int[] array, int len){
    if(array.length < len){return -1;}
    return array.length;
}

}