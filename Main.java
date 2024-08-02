import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                System.out.println("Выполняется действие 1");
            } else if (i == 2) {
                System.out.println("Выполняется действие 2");
            } else if (i == 3) {
                System.out.println("Выполняется действие 3");
            } else if (i == 4) {
                System.out.println("До встречи!");
                return;
            } else {
                System.out.println("Такая команда отсутствует");
            }
            System.out.println("Пробная строка для возврата");
        }
    }

    public static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определнный месяц");
        System.out.println("4 - Выйти из приложения");
    }
}