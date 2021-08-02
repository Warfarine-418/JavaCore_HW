package HW5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.load("src/main/java/HW5/data.txt");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));
        appData.save("src/main/java/HW5/dataSave.txt");
    }
}
//    1.Реализовать сохранение данных в csv файл;
//    2.Реализовать загрузку данных из csv файла. Файл читается целиком.

//      Строка заголовок с набором столбцов
//        Набор строк с целочисленными значениями
//        * Разделитель между столбцами - символ точка с запятой (;)