public class Converter {
    public static final double STEP_LENGTH = 75E-5;
    public static final double KCAL_IN_STEP = 5E-3;

    double convertToKm(double steps) {
        return steps * STEP_LENGTH;
    }

    double convertStepsToKilocalories(double steps) {
        return steps * KCAL_IN_STEP;
    }
}
