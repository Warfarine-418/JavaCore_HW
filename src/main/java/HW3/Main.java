package HW3;

public class Main {
    public static void main(String[] args) {


        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        swapTheArrEl(array1, 1, 2);
        PrintArray(array1);


    }

    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
    }

    public static void swapTheArrEl(int[] array, int x, int y) {
        int z = array[x - 1];
        array[x - 1] = array[y - 1];
        array[y - 1] = z;
    }

}
