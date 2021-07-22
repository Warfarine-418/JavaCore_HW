package HW2;

public class Main {
    private static final int MEGAGRAYS = 4;

    public static void main(String[] args) {

//        String[][] arrayWrongSize = {{"1", "2", "3", "4"}, {"1", "e", "4", "5"}, {"red", "4", "3", "6"}, {"8", "ten", "7", "9", "14"}};
//        checkTheArray(arrayWrongSize);
//        System.out.println(sumArrayElements(arrayWrongSize));
//
//        String[][] arrayNotInt = {{"1", "2", "3", "4"}, {"1", "e", "4", "5"}, {"red", "4", "3", "6"}, {"8", "ten", "7", "9"}};
//        checkTheArray(arrayNotInt);
//        System.out.println(sumArrayElements(arrayNotInt));

        String[][] arrayCorrect = {{"1", "2", "3", "4"}, {"1", "0", "4", "5"}, {"0", "4", "3", "6"}, {"8", "0", "7", "9"}};
        checkTheArray(arrayCorrect);
        System.out.println(sumArrayElements(arrayCorrect));

    }

    public static void checkTheArray(String[][] array) {
        for (int i = 0; i < MEGAGRAYS; i++) {
            if (array[i].length != MEGAGRAYS) {
                throw new MyArraySizeException("Данный массив должен быть размера 4х4!");
            }
        }
        System.out.println("Массив 4х4!");

    }

    public static int sumArrayElements(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("В массиве присутствуют неверные данные или элемент:" + "[" + i + "]" + "[" + j + "]");
                }
            }
        }
        return sum;
    }
//    1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
//    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.


//    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//    Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо числа),
//    надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.


//    3. В методе main() вызвать полученный метод, обработать возможные исключения
//    MySizeArrayException и MyArrayDataException и вывести результат расчета.
}
