import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForLoopExample {
    public static void main(String[] args) {
        for(int counter = 0; counter < 10; counter++) {
            System.out.printf("Counter is %d%n", counter);
        }

        String[] fruits = {"apple", "orange", "pear", "plum"};
        for(int counter = 0; counter < fruits.length; counter++) {
            System.out.println("Current fruit is " + fruits[counter]);
        }
        for(String fruit : fruits) {
            System.out.println("Current fruit is " + fruit);
        }

        String people = """
                Flintstone, Fred, 1/1/1900
                Rubble, Barney, 2/2/1905
                Flintstone, Wilma, 3/3/1910
                Rubble, Betty, 4/4/1915
                """;
        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*" +
                "(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";

        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        while(mat.find()) {
            System.out.printf("%s %s, born %s%n", mat.group("firstName"),
                    mat.group("lastName"), mat.group("dob"));
        }

        //Exercise 1
        for(int i = 1; i <= 10; i++) {
            System.out.println("7 * " + i + " = " + (i * 7));
        }

        //Exercise 2
        for(int i = 0; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i <= 20; i++) {
            if(i % 2 == 1) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        //Exercise 3
        for(int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println("Liftoff!");

        //Exercise 4
        int[] scores = {88, 92, 75, 64, 99};
        int total = 0;
        double average = 0.0;
        for(int score : scores) {
            total += score;
        }
        average = (double) total / scores.length;
        System.out.println(total + " " + average);

        //Exercise 5
        int maxScore = scores[0];
        for(int i = 1; i < scores.length; i++){
            if(maxScore < scores[i]) {
                maxScore = scores[i];
            }
        }
        System.out.println("maxScore " + maxScore);

        //Exercise 6
        String[] names = {"Ann", "Bob", "Carla", "Dave"};
        for(String name : names) {
            if(name.length() > 3) {
                System.out.println(name);
                break;
            }
        }

        //Exercise 7
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(j < i) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //Exercise 8
        //see GuessIt guessingGame()

        //Exercise 9
        String text = """
                Hello the best, THE the
                the    the thethe!
                """;
        regex = "\\bthe\\b";
        pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        mat = pat.matcher(text);
        int count = 0;
        while(mat.find()) {
            count++;
        }
        System.out.println("Count of 'the' is " + count);

        //Exercise 10
        regex = "\\b\\S+?@\\S+?\\.\\S+\\b";
        text = "dgfd@mail.ru fghfhgg fghfg try234@gmail.com";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        System.out.println("Exercise 10:");
        while(mat.find()) {
            System.out.println(mat.group(0) + " " + mat.start());
        }



    }
}
