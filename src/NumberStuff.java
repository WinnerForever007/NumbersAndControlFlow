import java.math.BigDecimal;

public class NumberStuff {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(37));
        System.out.println(0b100101);
        NumberStuff myInstance = new NumberStuff();
        System.out.println(myInstance);
        int thousand = 0x3E8;
        System.out.println(thousand);
        System.out.println(Integer.toHexString(1000));
        System.out.println(0xFACE);
        char myA = 'A';
        System.out.println((int) myA);
        char myChar = '강';
        System.out.println(myChar);
        myInstance.decimalToBinary();
        System.out.printf("%d %d %d%n", 0b1010, 0b11111, 0b10000000);
        System.out.println(Integer.toHexString(0b1011_0110) + " " +
                Integer.toHexString(0b0111_1111));
        System.out.printf("%d %d %d%n", 0xFF, 0x10, 0xCAFE);
        NumberStuff ns1 = new NumberStuff();
        NumberStuff ns2 = new NumberStuff();
        System.out.printf("%s %s%n", ns1, ns2);
        byte b = 127;
        System.out.printf("%d %d %d %s%n",(int) 'a', (int) 'Z', (int) '0', (char) 66);
        char c1 = 'é';
        char c2 = 'Ω';
        char c3 = '中';
        System.out.println(c1 + " " + (int) c1 + " " +
                c2 + " " + (int) c2 + " " + c3 + " " + (int) c3);
        short myShort = 32_767;
        char biggerShort = 32_768;
        char evenBigger = 64_000;
        System.out.println((int) evenBigger);
        double myDouble = 3.141592;
        float myFloat = 3.141592F;

        float num1 = 2.15F;
        float num2 = 1.10F;
        System.out.println(num1 - num2);
        BigDecimal a = new BigDecimal("2.15");
        BigDecimal b1 = new BigDecimal("1.10");
        System.out.println(a.subtract(b1));
        BigDecimal bd1 = new BigDecimal(1.10);
        System.out.println(bd1);
        System.out.println(0b01 | 0b10);
        ns1.printTheLimits();
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 1L);
        long big = 3_000_000_000L;
        System.out.println(0.1 + 0.2);
        System.out.println(0.1 + 0.2 == 0.3);
        double d1 = 1.0 / 3;
        float f1 = 1.0F / 3;
        System.out.println(d1 + " " + f1);
        System.out.println((1 | 8 | 32) + " " + Integer.toBinaryString((1 | 8 | 32)));
        int settings = 0b1010;
        System.out.println(settings & 0b1000);
        System.out.println(settings & 0b0100);
        System.out.println(settings & 0b0010);
        System.out.println((255 & 10) + "." + (255 & 0) + "." + (0 & 5)
                + "." + (77 & 0));

        int age = Integer.parseInt(args[0]);
        System.out.printf("You will be %d years old in 15 years.%n", age + 15);
    }

    private void decimalToBinary() {
        System.out.println("decimalToBinary method");
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(63));

    }

    private void printTheLimits() {
        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE + " " + Short.MAX_VALUE);
    }
}
