import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;
import java.security.SecureRandom;
import java.math.BigDecimal;

public class MathStuff {
    public static void main(String[] args) {
        MathStuff ms = new MathStuff();
        ms.examples();
        ms.testRandom();
        System.out.println(calcAreaOfCircle(3));
        System.out.println(calcPathVelocity(0.8, 3));
        System.out.println(calcCentripetalAcceleration(1.67, 0.8));
        System.out.println(calcCentripetalForce(0.2, 3.486125));
        System.out.println(calcCentripetalForce(0.2, 0.8, 3));
        System.out.println(Math.abs((0.1 + 0.2) - 0.3) < 0.000001);
        System.out.printf("%d %d %f %f %d %d%n", 10 / 3, 10 % 3, 10.0 / 3, (double) (10 / 3),
                2 + 6 / 2 * 3, (2 + 6) / (2 * 2));
        int a = 85;
        int b = 90;
        int c = 78;
        int res1 = (a + b + c) / 3;
        double res2 = (a + b + c) / 3.0;
        System.out.printf("%d %f%n", res1, res2);
        findEvenOrOdd(17);
        findEvenOrOdd(42);
        findEvenOrOdd(0);
        System.out.println(367 / 60 + " minutes and " + 367 % 60 + " seconds");

        int x = 5;
        System.out.println(x++);
        System.out.println(x);
        System.out.println(--x);
        System.out.println(x += 10);
        System.out.printf("%f %f %d%n", Math.ceil(2.3), Math.floor(2.3), Math.round(2.3));
        System.out.printf("%f %f %d%n", Math.ceil(2.7), Math.floor(2.7), Math.round(2.7));
        System.out.printf("%f %f %d%n", Math.ceil(2.5), Math.floor(2.5), Math.round(2.5));
        System.out.printf("%f %f %d%n", Math.ceil(-2.5), Math.floor(-2.5), Math.round(-2.5));
        System.out.printf("%f %f%n", Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2)),
                Math.hypot(3, 4));

        Random random = new Random();
        int r1 = random.nextInt(1, 7);
        int r2 = random.nextInt(1, 7);
        System.out.println(r1 + " " + r2 + " sum = " + (r1 + r2));
        r1 = (int) (Math.random() * 6) + 1;
        r2 = (int) (Math.random() * 6) + 1;
        System.out.println(r1 + " " + r2 + " sum = " + (r1 + r2));

        Random rand1 = new Random(42);
        System.out.printf("%d %d %d%n", rand1.nextInt(100), rand1.nextInt(100),
                rand1.nextInt(100));

        System.out.println(calcCircumference(3));
        System.out.println(celsiusToFahrenheit(100) + "F");
        System.out.println(fahrenheitToCelsius(32) + "C");
        int a1 = 7;
        int a2 = 12;
        System.out.printf("%b %b %b %b %b %b%n", a1 < a2, a1 <= a2, a1 == a2, a1 > a2,
                a1 >= a2, a1 != a2);

        // Exact Arithmetic with BigDecimal and BigInteger
        BigDecimal num3 = new BigDecimal("2.15");
        BigDecimal num4 = new BigDecimal("1.10");
        System.out.println(num3.subtract(num4));
        System.out.println(new BigDecimal("0.314").add(new BigDecimal("5.321")));
        System.out.println(new BigDecimal("0.314").subtract(new BigDecimal("5.321")));
        System.out.println(new BigDecimal("0.314").multiply(new BigDecimal("5.321")));
        BigDecimal total = new BigDecimal("5");
        total = total.add(BigDecimal.ONE);
        System.out.println(total);
        BigDecimal result = new BigDecimal("10").add(new BigDecimal("5"))
                .multiply(new BigDecimal("2"));

        MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal("0.314")
                .divide(new BigDecimal("5.321"), mc));

        MathContext mc2 = new MathContext(7 ,RoundingMode.HALF_UP);
        System.out.println(new BigDecimal("49").sqrt(mc2));
        System.out.println(new BigDecimal("0.054798").sqrt(mc2));
        System.out.println(new BigDecimal("7").max(new BigDecimal("13")));
        System.out.println(new BigDecimal("7").min(new BigDecimal("13")));
        System.out.println(new BigDecimal("-7").abs());
        System.out.println(new BigDecimal("13").remainder(new BigDecimal("8")));
        System.out.println(new BigDecimal("1.08").pow(2));

        BigDecimal d = new BigDecimal("2.0");
        BigDecimal e = new BigDecimal("2.00");
        System.out.println(d.compareTo(e));
        System.out.println(d.equals(e));
        BigDecimal num1 = new BigDecimal("100");
        byte byteValue1 = num1.byteValue();
        System.out.println(byteValue1);
        System.out.println(new BigDecimal("3.141592").byteValue());
        System.out.println(new BigDecimal("1024").byteValue());
        System.out.println(new BigDecimal("1024").doubleValue());
        String myString = num1.toString();
        System.out.println(myString);

        BigInteger huge = new BigInteger("123456789012345678901234567890");
        BigInteger product = huge.multiply(new BigInteger("987654321"));
        System.out.println(product);
        BigDecimal pi = new BigDecimal("3.141592");
        System.out.println(pi.unscaledValue());
        System.out.println(pi.scale());
    }

    public static int celsiusToFahrenheit(int celsius) {
        double fahrenheit = celsius * 9.0 / 5.0 + 32;
        return (int) Math.round(fahrenheit);
    }

    public static int fahrenheitToCelsius(int fahrenheit) {
        double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        return (int) Math.round(celsius);
    }

    public static void findEvenOrOdd(int number) {
        if(number % 2 == 0){
            System.out.println(number + " is even");
        }
        else {
            System.out.println(number + " is odd");
        }
    }

    private void examples() {
        System.out.println(3 + 5);
        System.out.println(3 + 5 + 2 + 10);
        System.out.println(7 - 10);
        System.out.println(7 * 4);
        System.out.println(8 / 4);
        System.out.println(7 - 10 + 3 - 9);
        System.out.println(64 / 8 / 4);
        System.out.println(8 * 8 / 8 / 4);
        System.out.println(7 / 4);
        System.out.println(7F / 4);
        System.out.println(7 / 4F);
        System.out.println(7.0 / 4);
        System.out.println(7D / 4);
        System.out.println((double) 7 / 4);
        System.out.println(7 / (float) 4);
        System.out.println(Math.random() + " " + Math.random());
        System.out.println((int) 7.6);
    }

    public void testRandom() {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(1, 7));
        SecureRandom secureRandom = new SecureRandom();
        System.out.println(secureRandom.nextInt(10));
    }

    /**
     * Calculates the area of a circle using the formula area = π × radius².
     *
     * @param radius the radius of the circle
     * @return the area of the circle
     */
    public  static double calcAreaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculates the circumference of a circle using the formula
     * circumference = 2 × π × radius.
     *
     * @param radius the radius of the circle
     * @return the circumference of the circle
     */
    public static double calcCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double calcCentripetalForce(double mass, double radius,
                                              double period) {
        double pathVelocity = calcPathVelocity(radius, period);
        double centripetalAcceleration = calcCentripetalAcceleration(pathVelocity, radius);
        return calcCentripetalForce(mass, centripetalAcceleration);
    }

    public static double calcCentripetalForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    private static double calcPathVelocity(double radius, double period) {
        double circumference = 2 * Math.PI * radius;
        return circumference / period;
    }

    private static double calcCentripetalAcceleration(double pathVelocity, double radius){
        double pow1 = Math.pow(pathVelocity, 2);
        return pow1 / radius;
    }


}
