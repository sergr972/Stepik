import java.util.Scanner;

public class step5_3_13 {
    public static void main(String[] args) {

        double sum = 0;
        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNext()) {
                if (scan.hasNextDouble()) {
                    sum += Double.parseDouble(scan.next());
                } else {
                    scan.next();
                }
            }

            System.out.printf("%.6f", sum);
        } catch (Exception e) {
            System.out.printf("%.6f", 0);
        }
    }
}
