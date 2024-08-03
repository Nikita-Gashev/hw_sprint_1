import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if ((monthNumber >= 1) & (monthNumber <= 12)) {
            System.out.println("Введите день от 1 до 30 (включительно)");
            int daysNumber = scanner.nextInt();
            if ((daysNumber >= 1) & (daysNumber <= 30)) {
                System.out.println("Введите количество шагов");
                int numberSteps = scanner.nextInt();
                if (numberSteps > 0) {
                    MonthData monthData = monthToData[monthNumber-1];
                    monthData.days[daysNumber] = numberSteps;
                } else {
                    System.out.println("Введено некорректное значение шагов");
                    return;
                }
            } else {
                System.out.println("Введен некорректный день");
                return;
            }
        } else {
            System.out.println("Введен некорректный номер месяца");
            return;
        }
    }
    void changeStepGoal() {
        System.out.println("Введите новую цель шагов на день");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay > 0) {
            System.out.println("Ваша новая цель: " + goalByStepsPerDay + " шагов.");
        } else {
            System.out.println("Введено некорректное значение");
            return;
        }
    }
}
