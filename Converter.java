public class Converter {
    double convertToKm(double steps) {
        final double STEP_LENGTH = 75E-5;
        return steps * STEP_LENGTH;
    }

    double convertStepsToKilocalories(double steps) {
        final double KCAL_IN_STEP = 5E-3;
        return steps * KCAL_IN_STEP;
    }
}
