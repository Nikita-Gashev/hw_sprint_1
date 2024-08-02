import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

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
        }
    }
}