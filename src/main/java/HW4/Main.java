package HW4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {"Иван", "Олег", "Сергей", "Юрий", "Андрей", "Ольга",
                "Мария", "Иван", "Олег", "Ольга", "Ирина", "Жанна"};
        uniqueElementInArr(array);
        numberOfRepeatElementsInArr(array);

    }

    public static void uniqueElementInArr(String[] arr) {
        LinkedHashSet<String> unique = new LinkedHashSet<>();
        for (String s : arr) {
            if (unique.contains(s)) {
                continue;
            }
            for (String value : arr) {
                if (s.equals(value)) {
                    unique.add(s);
                    break;
                }
            }
        }
        System.out.println(unique);
    }

    public static void numberOfRepeatElementsInArr(String[] arr) {
        LinkedHashMap<String, Integer> repeatWordNumber = new LinkedHashMap<>();
        for (String element : arr) {
            if (!repeatWordNumber.containsKey(element)) {
                repeatWordNumber.put(element, 0);
            }
            repeatWordNumber.put(element, repeatWordNumber.get(element) + 1);
        }
        System.out.println(repeatWordNumber);
    }
}


//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать, сколько раз встречается каждое слово.


//        Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи,
//        а с помощью метода get() искать номер телефона по фамилии.
//        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//        тогда при запросе такой фамилии должны выводиться все телефоны.
//        Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//        взаимодействие с пользователем через консоль и т.д).
//        Консоль использовать только для вывода результатов проверки телефонного справочника.