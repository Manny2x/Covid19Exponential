import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Covid19ExpoGrowth {
    public static void main(String[] args) {
        try {
            calculateGrowth();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("You can now work out your "
                + "own Exponential Growth");

        // User works out chosen exponential growth
        Scanner scan = new Scanner(System.in);
        while (getUserInput(scan));
        scan.close();
    }

    private static void calculateGrowth() throws IOException {
        // I will use the formula y = a(1 + r)^x
        // a = initial value
        // r = growth rate
        // x = time interval
        int a;
        double r;
        int x;

        // Workout exponential growth
        System.out.println("Let us see the Exponential "
                + "growth of Covid-19.");
        System.out.println(
                "We will set the initial value of Covid "
                + "as 88,000 as that was the amount of "
                + "cases in February.");
        System.out.println();
        a = 88_000;
        System.out.println("We need to find the growth "
                + "rate of Covid-19, we can use the "
                + "growthRate method.");
        System.out.println("We'll assume a linear growth rate "
                + "of 14,000 cases a month.");
        System.out.println();
        r = growthRate(a, 14_000d + a) / 30d;
        String output = String.format("%.6f", r);
        System.out.println("Using the growthRate method, "
                        + "we worked out the growth "
                        + "rate is: " + output + ".");
        System.out.println();
        System.out.println("The time interval will be "
                + "from February 1, 2020 - April 16, 2020,"
                + " 45 days.");
        x = 45;
        System.out.println("Now we have all the values "
                + "let us use the method calculateExpoGrowth");
        System.out.println();
        double roundedExpo = calculateExpoGrowth(a, r, x);
        DecimalFormat formatter = new DecimalFormat(
                "###,###,###");
        output = formatter.format(roundedExpo);
        System.out.println("The Exponential growth of "
                + "Covid 19 is " + output 
                + " cases by April 16, 2020.");
    }

    private static boolean getUserInput(Scanner scan) {
        int a;
        double r;
        int x;

        System.out.println("Please enter the initial value");
        String value = scan.nextLine().trim();
        if (value.isEmpty()) {
            return false;
        }

        a = Integer.valueOf(value);

        System.out.println("Enter WORKOUT GROWTH RATE if you "
                + "would like to workout the growth rate,"
                + "if you already know it press enter");
        String gr = scan.nextLine().trim();
        if (gr.equalsIgnoreCase("WORKOUT GROWTH RATE")) {
            int pastValue;
            int presentValue;

            System.out.println("Please enter the past value");
            pastValue = Integer.valueOf(scan.nextLine().trim());

            System.out.println("Please enter the present value");
            presentValue = Integer.valueOf(scan.nextLine().trim());

            System.out.println("Please enter the days");
            int days = Integer.valueOf(scan.nextLine().trim());

            r = growthRate(pastValue, presentValue) / days;
        } else {
            System.out.println("Please type in the growth rate");
            r = Double.valueOf(scan.nextLine().trim());
        }
        System.out.println("Now finally, type in the time "
                + "interval");
        x = Integer.valueOf(scan.nextLine().trim());
        double roundedExpo2 = calculateExpoGrowth(a, r, x);
        DecimalFormat formatter = new DecimalFormat(
                "###,###,###");
        String output = formatter.format(roundedExpo2);
        System.out.println(
                "The program has calculated the Exponential "
                + "growth is: " + output + ".");
        return true;
    }

    public static double growthRate(double pastVal, 
            double presentVal) {
        double newVal = presentVal - pastVal;
        return newVal / pastVal;
    }

    public static double calculateExpoGrowth(int a, double r, 
            int x) {
        // Exponential growth formula
        return (a * Math.pow((1d + r), (double) x));
    }
}
