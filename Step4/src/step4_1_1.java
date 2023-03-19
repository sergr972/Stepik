package Step4;

public class step4_1_1 {

    public static void main(String[] args) {
        double x = 128;
        sqrt(x);
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }
}

