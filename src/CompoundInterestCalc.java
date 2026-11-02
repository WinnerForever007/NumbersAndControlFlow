import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class CompoundInterestCalc {

    /**
     * Calculates a compound interest balance with annual contributions
     * made at the end of each year, using the formula
     * B = P(1 + r)^y + c * [((1 + r)^y - 1) / r].
     *
     * @param principal    the starting balance, e.g. "10000"
     * @param rate         the annual rate of return as a decimal, e.g. "0.08" for 8%
     * @param period       the number of years
     * @param contribution the amount added at the end of each year, e.g. "1000"
     * @return the balance after the given number of years
     */
    public static BigDecimal calculate (String principal, String rate,
                                        int period, String contribution) {
        BigDecimal r = new BigDecimal(rate);

        // (1 + r)^y
        BigDecimal growthFactor = BigDecimal.ONE.add(r).pow(period);

        // P * (1 + r)^y: the starting balance after growth
        BigDecimal grownPrincipal = growthFactor.multiply(new BigDecimal(principal));

        // ((1 + r)^y - 1) / r
        BigDecimal contributionFactor = growthFactor.subtract(BigDecimal.ONE).divide(r);

        // c * [((1 + r)^y - 1) / r]: all contributions plus their growth
        BigDecimal grownContributions = contributionFactor.multiply(new
                BigDecimal(contribution));

        // B = P(1 + r)^y + c * [...]
        return grownPrincipal.add(grownContributions);
    }

    public static BigDecimal calculateInPercent(String principal, String rate,
                                                int period, String contribution) {
        BigDecimal r = new BigDecimal(rate);
        r = r.divide(new BigDecimal("100"));
        r = r.multiply(new BigDecimal("100"));
        r = r.movePointLeft(2);

        // (1 + r)^y
        BigDecimal growthFactor = BigDecimal.ONE.add(r).pow(period);

        // P * (1 + r)^y: the starting balance after growth
        BigDecimal grownPrincipal = growthFactor.multiply(new BigDecimal(principal));

        // ((1 + r)^y - 1) / r
        BigDecimal contributionFactor = growthFactor.subtract(BigDecimal.ONE).divide(r);

        // c * [((1 + r)^y - 1) / r]: all contributions plus their growth
        BigDecimal grownContributions = contributionFactor.multiply(new
                BigDecimal(contribution));

        // B = P(1 + r)^y + c * [...]
        return grownPrincipal.add(grownContributions);
    }

    public static BigDecimal calculateStartOfYear(String principal, String rate,
                                                  int period, String contribution) {
        BigDecimal r = new BigDecimal(rate);

        // (1 + r)^y
        BigDecimal growthFactor = BigDecimal.ONE.add(r).pow(period);

        // P * (1 + r)^y: the starting balance after growth
        BigDecimal grownPrincipal = growthFactor.multiply(new BigDecimal(principal));

        // ((1 + r)^y - 1) / r * (1 + r)
        BigDecimal contributionFactor = growthFactor.subtract(BigDecimal.ONE).divide(r)
                .multiply(BigDecimal.ONE.add(r));

        // c * [((1 + r)^y - 1) / r]: all contributions plus their growth
        BigDecimal grownContributions = contributionFactor.multiply(new
                BigDecimal(contribution));

        // B = P(1 + r)^y + c * [...]
        return grownPrincipal.add(grownContributions);
    }

    public static void main(String[] args) {
        BigDecimal balance = calculate("10000", "0.08", 10, "1000");
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));

        // Exercises "Exact Arithmetic with BigDecimal and BigInteger"
        System.out.println(0.1 + 0.2);
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal(0.1) + " " + new BigDecimal("0.1")
        + " " + BigDecimal.valueOf(0.1));
        BigDecimal price = new BigDecimal("19.99");
        price.add(new BigDecimal("5"));
        System.out.println(price);
        price = price.add(new BigDecimal("5"));
        System.out.println(price);

        // Exercise 4
        BigDecimal result = new BigDecimal("19.99").add(new BigDecimal("5.49"))
                .add(new BigDecimal("0.99"));
        System.out.println(result);
        BigDecimal result2 = result;
        result = result.multiply(new BigDecimal("0.08")).add(result);
        result2 = result2.multiply(BigDecimal.ONE.add(new BigDecimal("0.08")));
        System.out.println("result " + result.setScale(2, RoundingMode.HALF_UP));
        System.out.println("result2 " + result2.setScale(2, RoundingMode.HALF_UP));

        //Exercise 5
//        System.out.println(new BigDecimal("100.00").divide(new BigDecimal("3")));
        MathContext mc1 = new MathContext(4 ,RoundingMode.HALF_EVEN);
        System.out.println(new BigDecimal("100.00")
                .divide(new BigDecimal("3"), mc1));
        System.out.println(new BigDecimal("100.00").divide(new BigDecimal("3"),
                2, RoundingMode.HALF_EVEN));

        //Exercise 6
        BigDecimal bd1 = new BigDecimal("2.345");
        BigDecimal bd2 = new BigDecimal("2.355");
        System.out.println("2.345 " + bd1.setScale(2, RoundingMode.HALF_UP) + " "
                + bd1.setScale(2, RoundingMode.HALF_EVEN) + " "
                + bd1.setScale(2, RoundingMode.DOWN) + " "
                + bd1.setScale(2, RoundingMode.CEILING));
        System.out.println("2.355 " + bd2.setScale(2, RoundingMode.HALF_UP) + " "
                + bd2.setScale(2, RoundingMode.HALF_EVEN) + " "
                + bd2.setScale(2, RoundingMode.DOWN) + " "
                + bd2.setScale(2, RoundingMode.CEILING));
        //Exercise 7
        BigDecimal bd3 = new BigDecimal("10.0");
        BigDecimal bd4 = new BigDecimal("10.00");
        System.out.println(bd3.compareTo(bd4));
        System.out.println(bd3.equals(bd4));
        //Exercise 8
        bd3 = BigDecimal.valueOf(300);
        System.out.println(bd3.byteValue() + " " + bd3.intValue() + " "
                + bd3.doubleValue() /*+ " " + bd3.byteValueExact()*/);
        //Exercise 9
        BigInteger bi1 = BigInteger.ONE;
        for(int i = 2; i < 26; i++) {
            bi1 = bi1.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bi1);
        long factorial = 1;
        for(int i = 2; i < 26; i++) {
            factorial *= i;
        }
        System.out.println(factorial);

        //Exercise 10
        balance = calculateStartOfYear("10000", "0.08", 10, "1000");
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));

        //Exercise 11
        balance = calculateInPercent("10000", "8", 10, "1000");
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));

    }
}
