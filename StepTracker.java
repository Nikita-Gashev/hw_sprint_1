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
                    MonthData monthData = monthToData[monthNumber - 1];
                    monthData.days[daysNumber - 1] = numberSteps;
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
            System.out.printf("Ваша новая цель: %s шагов.%n", goalByStepsPerDay);
        } else {
            System.out.println("Введено некорректное значение");
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if ((monthNumber >= 1) & (monthNumber <= 12)) {
            MonthData monthData = monthToData[monthNumber - 1];
            int sumSteps = monthData.sumStepsFromMonth();

            System.out.println("Общая статистика по дням:");
            monthData.printDaysAndStepsFromMonth();
            System.out.printf("Общее количество шагов за месяц: %d%n", sumSteps);
            System.out.printf("Максимальное пройденное количество шагов за месяц: %d%n", monthData.getMaxSteps());
            System.out.printf("Среднее пройденное количество шагов за месяц: %d%n", sumSteps / 30);
            System.out.printf("Пройденная за месяц дистанция в км: %1.0f%n", converter.convertToKm(sumSteps));
            System.out.printf("Количество сожженых килокалорий за месяц: %1.0f%n", converter.convertStepsToKilocalories(sumSteps));
            System.out.printf("Лучшая серия за месяц: %d%n%n", monthData.getBestSeries(goalByStepsPerDay));
        } else {
            System.out.println("Введен некорректный номер месяца");
        }
    }
}
