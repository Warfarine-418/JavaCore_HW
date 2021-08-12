package HW6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует Яндекс Погода в городе Москва");

        while (true) {

            System.out.println("Введите 1 или 5, если хотите получить погоду на 1 или 5 дней, если хотите выйти - введите 0: ");
            String command = scanner.nextLine();
            if (command.equals("0")) {
                System.out.println("До свидания!");
                break;
            }
            if (command.equals("1") | command.equals("5")) {
                try {
                    controller.getWeather(command);
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            } else System.out.println("Вы ввели некорректные данные, попробуйте еще раз");


        }
    }
}
