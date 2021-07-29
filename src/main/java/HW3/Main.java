package HW3;

public class Main {
    public static void main(String[] args) {


        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        swapTheArrEl(array1, 1, 2);
        printArray(array1);


    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " | ");
        }
        System.out.println();
    }

    public static void swapTheArrEl(int[] array, int x, int y) {
        int z = array[x - 1];
        array[x - 1] = array[y - 1];
        array[y - 1] = z;
    }

}
