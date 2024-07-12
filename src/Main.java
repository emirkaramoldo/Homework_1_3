import java.util.Random;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double[] numbers = new double[15];

        Random random = new Random();
        numbers[0] = random.nextDouble() * 100;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = random.nextDouble() * 100;
            if (random.nextBoolean()) {
                numbers[i] *= -1;
            }
        }

        boolean foundFirstNegative = false;
        double sum = 0;
        int count = 0;

        for (double number : numbers) {
            if (foundFirstNegative && number > 0) {
                sum += number;
                count++;
            } else if (number < 0) {
                foundFirstNegative = true;
            }
        }

        double average = sum / count;
        System.out.println("Среднее арифметическое положительных чисел после первого отрицательного: " + formatDouble(average));
    }

    public static String formatDouble(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(number);
    }
}