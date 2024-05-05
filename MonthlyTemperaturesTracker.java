import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store month names
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // Array to store temperatures for each month
        double[] temperatures = new double[12];

        // Prompt user to input temperatures for each month
        for (int i = 0; i < months.length; i++) {
            System.out.print("Enter temperature for " + months[i] + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        // Display options to the user
        System.out.println("Enter a month to view its temperature, or 'year' to view yearly statistics:");

        // Read user input
        String input = scanner.next();

        // Check if the user wants to view monthly or yearly data
        if (input.equalsIgnoreCase("year")) {
            double yearlySum = 0;
            double highestMonthlyAverage = temperatures[0];
            double lowestMonthlyAverage = temperatures[0];

            // Calculate yearly statistics
            for (int i = 0; i < temperatures.length; i++) {
                yearlySum += temperatures[i];
                if (temperatures[i] > highestMonthlyAverage) {
                    highestMonthlyAverage = temperatures[i];
                }
                if (temperatures[i] < lowestMonthlyAverage) {
                    lowestMonthlyAverage = temperatures[i];
                }
            }

            // Calculate yearly average
            double yearlyAverage = yearlySum / temperatures.length;

            // Display yearly statistics
            System.out.println("Yearly statistics:");
            for (int i = 0; i < months.length; i++) {
                System.out.println(months[i] + ": " + temperatures[i]);
            }
            System.out.println("Yearly Average: " + yearlyAverage);
            System.out.println("Highest Monthly Average: " + highestMonthlyAverage);
            System.out.println("Lowest Monthly Average: " + lowestMonthlyAverage);
        } else {
            // Display temperature for the requested month
            int index = -1;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(input)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("Temperature for " + months[index] + ": " + temperatures[index]);
            } else {
                System.out.println("Invalid month entered.");
            }
        }

        scanner.close();
    }
}
