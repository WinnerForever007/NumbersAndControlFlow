import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompoundInterestCalc {

    private static final NumberFormat moneyFormatter =
            NumberFormat.getCurrencyInstance(Locale.US);
    private static final NumberFormat percentFormatter =
            NumberFormat.getPercentInstance(Locale.US);

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
                                        int period, String contribution) throws ParseException {
        //BigDecimal r = new BigDecimal(rate);
        BigDecimal r = new BigDecimal(percentFormatter.parse(rate).toString());

        // (1 + r)^y
        BigDecimal growthFactor = BigDecimal.ONE.add(r).pow(period);

        // P * (1 + r)^y: the starting balance after growth
        //BigDecimal grownPrincipal = growthFactor.multiply(new BigDecimal(principal));
        BigDecimal grownPrincipal = growthFactor.multiply(
                new BigDecimal(moneyFormatter.parse(principal).toString()));

        // ((1 + r)^y - 1) / r
        BigDecimal contributionFactor = growthFactor.subtract(BigDecimal.ONE).divide(r);

        // c * [((1 + r)^y - 1) / r]: all contributions plus their growth
        //BigDecimal grownContributions = contributionFactor.multiply(new
        //        BigDecimal(contribution));
        BigDecimal grownContributions = contributionFactor.multiply(new
                BigDecimal(moneyFormatter.parse(contribution).toString()));

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

    public static void describe(Object o) {
        System.out.println(o + " " + o.getClass().getSimpleName());
    }

    public static void main(String[] args) throws ParseException {
        /*BigDecimal balance = calculate("10000", "0.08", 10, "1000");
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));*/

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
        BigDecimal balance;
        balance = calculateStartOfYear("10000", "0.08", 10, "1000");
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));

        //Exercise 11
        balance = calculateInPercent("10000", "8", 10, "1000");
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));

        //Formatting Numbers and Numeric Wrapper Classes
        //

        NumberFormat moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        balance = calculate("$10,000.00", "8%", 10, "$1,000.00");
        System.out.println(moneyFormatter.format(balance));
        balance = calculate("$25,300.00", "8%", 10, "$7,500.00");
        System.out.println(moneyFormatter.format(balance));

        DecimalFormat df = new DecimalFormat("$#,##0.00",
                new DecimalFormatSymbols(Locale.US));
        System.out.println(df.format(balance));
        System.out.println(new DecimalFormat("0,000,000,000.00",
                new DecimalFormatSymbols(Locale.US)).format(balance));

        DecimalFormat pdf = new DecimalFormat("#%");
        System.out.println(pdf.format(0.08));
        DecimalFormat big = new DecimalFormat("#,###%",
                new DecimalFormatSymbols(Locale.US));
        System.out.println(big.format(2737.08));

        df = new DecimalFormat("$#,##0.00; ($#)", new DecimalFormatSymbols(Locale.US));
        System.out.println(df.format(balance));
        System.out.println(df.format(balance.negate()));

        System.out.printf("%f%n", balance);
        System.out.printf(Locale.US,"$%,.2f%n", balance);
        System.out.printf(Locale.US, "%(,.2f%n", balance.negate());
        String myMoney = String.format(Locale.US, "$%,.2f", balance);
        System.out.println(myMoney);

        String summary = String.format(Locale.US,
                "After %d years at %.1f%%, your balance is $%,.2f.",
                10, 8.0, balance);
        System.out.println(summary);

        Integer myInt = Integer.valueOf(7);
        Double myDouble = Double.valueOf(3.14);
        Float myFloat = Float.valueOf(3.14F);
        Byte myByte = Byte.valueOf("7");
        Long myLong = Long.valueOf("9000000000");

        //Exercise 1
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.US);
        BigDecimal balance2 = new BigDecimal("1234567.891");
        System.out.println(moneyFormatter2.format(balance2));
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(moneyFormatter2.format(balance2));
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(moneyFormatter2.format(balance2));
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(moneyFormatter2.format(balance2));
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        System.out.println(moneyFormatter2.format(balance2));
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.KOREAN);
        System.out.println(moneyFormatter2.format(balance2));

        //Exercise 2
        NumberFormat nf1 = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(percentFormatter.format(0.075));
        System.out.println(percentFormatter.format(0.5));
        System.out.println(percentFormatter.format(1.25));
        percentFormatter.setMinimumFractionDigits(1);
        System.out.println(percentFormatter.format(0.075));
        System.out.println(percentFormatter.format(0.5));
        System.out.println(percentFormatter.format(1.25));

        //Exercise 3
        moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.US);
        Number number1 = moneyFormatter2.parse("$1,234.56");
        Number number2 = nf1.parse("12.5%");
        System.out.println(number1 + " " + number1.getClass().getSimpleName());
        System.out.println(number2 + " " + number2.getClass().getSimpleName());

        //Exercise 4
        BigDecimal bD = new BigDecimal("0.99");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        DecimalFormat dF = new DecimalFormat("$#,##0.00", dfs);
        System.out.println("Exercise 4 " + dF.format(bD));
        DecimalFormat thousandIntegerFormat = new DecimalFormat("#,##0", dfs);
        int c1 = 1231231323;
        System.out.println(thousandIntegerFormat.format(c1));
        DecimalFormat idFormat = new DecimalFormat("000000", dfs);
        int c2 = 1234;
        System.out.println(idFormat.format(c2));
        DecimalFormat percentFormat = new DecimalFormat("0.0%", dfs);
        System.out.println(percentFormat.format(0.123));

        //Exercise 5
        double value = 1234.50;
        System.out.printf(Locale.US, "$%,.2f%n %(,.2f%n", value, -value);

        //Exercise 6
        double val1 = 1234567.891;
        double val2 = -val1;
        System.out.printf("%1$f %1$.2f %1$,.2f %2$(,.2f%n", val1, val2);
        System.out.printf(Locale.US, "%1$f %1$.2f %1$,.2f %2$(,.2f%n", val1, val2);

        //Exercise 7
        int quantity = 3;
        String name = "Coffee";
        double unitPrice = 4.50;
        String result1 = String.format("%d x %s @ $%.2f = $%.2f", quantity, name,
                unitPrice, unitPrice * quantity);
        System.out.println(result1);

        //Exercise 8
        describe(7);
        describe(7L);
        describe('7');
        describe(7.0);
        describe(true);

        //Exercise 9
        Integer a = 100;
        Integer b = 100;
        Integer c = 500;
        Integer d = 500;
        System.out.println((a == b) + " " + a.equals(b) + " " + (c == d) + " " + c.equals(d));

        //Exercise 10
        Double d1 = Double.parseDouble(args[0]);
        Double d2 = Double.parseDouble(args[1]);
        System.out.printf("sum %.2f, difference %.2f, product %.2f, quotient %.2f%n",
                d1 + d2, d1 - d2, d1 * d2, d1 / d2);

        //Exercise 12
        balance = calculateStartOfYear(args[2], args[3], Integer.parseInt(args[4]), args[5]);
        System.out.println(balance.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println(moneyFormatter.format(balance));

    }
}
