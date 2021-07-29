package HW4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, int phone) {
        ArrayList<Integer> phoneNumber = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumber.add(phone);

        phoneBook.put(name, phoneNumber);
    }

    public ArrayList<Integer> get(String name) {
        return phoneBook.get(name);
    }

    @Override
    public String toString() {
        return "PhoneDirectory{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Иванов", 888888);
        phoneDirectory.add("Сидоров", 777777);
        phoneDirectory.add("Петров", 555555);
        phoneDirectory.add("Семенов", 888999);
        phoneDirectory.add("Иванов", 777888);
        System.out.println(phoneDirectory.get("Иванов"));
        System.out.println(phoneDirectory);

    }
}
