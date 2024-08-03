import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

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
                    monthData.days[daysNumber-1] = numberSteps;
                } else {
                    System.out.println("Введено некорректное значение шагов");
                }
            } else {
                System.out.println("Введен некорректный день");
            }
        } else {
            System.out.println("Введен некорректный номер месяца");

        }
    }
    void changeStepGoal() {
        System.out.println("Введите новую цель шагов на день");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay > 0) {
            System.out.println("Ваша новая цель: " + goalByStepsPerDay + " шагов.");
        } else {
            System.out.println("Введено некорректное значение");
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if ((monthNumber >= 1) & (monthNumber <= 12)) {
            MonthData monthData = monthToData[monthNumber-1];
            System.out.println("Общая статистика по дням:");
            monthData.printDaysAndStepsFromMonth();
            System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
            System.out.println("Максимальное пройденное количество шагов за месяц: " + monthData.maxSteps());
            System.out.println("Среднее пройденное количество шагов за месяц: " + monthData.sumStepsFromMonth()/30);
            System.out.println("Пройденная за месяц дистанция в км: " + converter.convertToKm(monthData.sumStepsFromMonth()));
            System.out.println("Количество сожженых килокалорий за месяц: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
            System.out.println("Лучшая серия за месяц: " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println();
        } else {
            System.out.println("Введен некорректный номер месяца");
        }
    }
}
