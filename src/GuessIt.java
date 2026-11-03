import java.util.Random;

public class GuessIt {
        public static void main(String[] args) {
        int randomNum = new Random().nextInt(5) + 1;
        System.out.printf("Generated number is %d%n", randomNum);
        if (randomNum == 3) {
            System.out.println("You got it!");
        } else {
            System.out.println("Sorry, you didn't get it.");
        }

        if (shouldIGo()) {
            System.out.println("You got it!");
        } else {
            System.out.println("Sorry, you didn't get it.");
        }

        if (randomNum == 1) {
            System.out.println("The color is red");
        } else if (randomNum == 2) {
            System.out.println("The color is green");
        } else if (randomNum == 3) {
            System.out.println("The color is blue");
        } else {
            System.out.println("The color is polka dot");
        }

        if (randomNum > 4 && (randomNum % 2 == 0)) {
            System.out.println("Big and even");
        }
        if (randomNum > 4 || (randomNum % 2 == 0)) {
            System.out.println("Big or even");
        }

//        switch(randomNum) {
//            case 1:
//                System.out.println("The color is red");
//                break;
//            case 2:
//                System.out.println("The color is blue");
//                break;
//            case 3:
//                System.out.println("The color is green");
//                break;
//            case 4:
//                System.out.println("The color is purple");
//                break;
//            default:
//                System.out.println("The color is whatever");
//        }

        String command = "go";

        if (command == null) {
            System.out.println("No command given");
        } else {
            switch (command) {
                case "stop":
                    System.out.println("Stopping now");
                    break;
                case "go":
                    System.out.println("Going now");
                    break;
                default:
                    System.out.println("Command not understood");
            }
        }

        if ("stop".equals(command)) {
            System.out.println("Stopping now");
        } else if ("go".equals(command)) {
            System.out.println("Going now");
        } else {
            System.out.println("Command not understood");
        }

        String card = "Jack";
        int currentTotalValue = 10;
        int currentValue = 0;

        //Exercise 8 & 9
        if (card.equals("Joker")) {
            System.out.println("Take a new card!");
        } else {
            currentValue = switch (card) {
                case "King", "Queen", "Jack" -> 10;
                case "Ace" -> {
                    if (currentTotalValue < 11) {
                        yield 11;
                    } else {
                        yield 1;
                    }
                }
                case "2" -> Integer.parseInt(card);
                case "3" -> Integer.parseInt(card);
                case "4" -> Integer.parseInt(card);
                case "5" -> Integer.parseInt(card);
                case "6" -> Integer.parseInt(card);
                case "7" -> Integer.parseInt(card);
                case "8" -> Integer.parseInt(card);
                case "9" -> Integer.parseInt(card);
                case "10" -> Integer.parseInt(card);
                default -> {
                    System.out.println("Error");
                    yield 0;
                }
            };
        }
        int resultValue = currentValue + currentTotalValue;
        System.out.printf("Current card value: %d%n", currentValue);
        System.out.printf("Total value: %d%n", resultValue);
        if(resultValue == 21) {
            System.out.println("Blackjack!");
        } else if(resultValue > 21) {
            System.out.println("Bust!");
        } else {
            System.out.println("Hit or stand?");
        }


        switch (command) {
            case null -> System.out.println("No command given");
            case "stop" -> System.out.println("Stopping now");
            case "go" -> System.out.println("Going now");
            default -> System.out.println("Command not understood");
        }

        //Control Flow first lection
        //Exercise 1
        int guess = new Random().nextInt(1, 11);
        if(guess < 6) {
            System.out.println("too low");
        } else if(guess > 7) {
            System.out.println("too high");
        } else {
            System.out.println("correct");
        }

        //Exercise 2
        int score = new Random().nextInt(0, 101);
        if(score < 60) {
            System.out.println("F");
        } else if(score >= 60 && score < 70) {
            System.out.println("D");
        } else if(score >= 70 && score < 80) {
            System.out.println("C");
        } else if(score >= 80 && score < 90) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }

        //Exercise 3
        int test = 2026;
        if((test % 4 == 0 && test % 100 != 0) || test % 400 == 0) {
            System.out.println(test + " is a leap year");
        } else {
            System.out.println(test + " is not a leap year");
        }

        //Exercise 4
        String day = "Monday";
        if(isWeekend(day)) {
            System.out.println("Work");
        } else {
            System.out.println("Relax");
        }

        //Exercise 5
        int month = 1;
        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println(31);
            case 2:
                System.out.println(28 +" or " + 29);
            case 4: case 6: case 9: case 11:
                System.out.println(30);
        }
        //Exercise 6
        int days = switch(month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 29;
        };
        System.out.println(days);

        //Exercise 7
        command = null;
        if("go".equals(command)){
            System.out.println("go equals command");
        }
        switch (command) {
            case null -> System.out.println("No command given");
            case "stop" -> System.out.println("Stopping now");
            case "go" -> System.out.println("Going now");
            default -> System.out.println("Command not understood");
        }



    }

    private static boolean shouldIGo() {
        return true;
    }

    private static boolean isWeekend(String day) {
            boolean result = switch(day) {
                case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> true;
                default -> false;
            };
            return result;
    }

}
