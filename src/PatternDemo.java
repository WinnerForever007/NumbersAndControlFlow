public class PatternDemo {
    record Person(String firstName, String lastName, int age) {}

    public static void main(String[] args) {
        String var1 = "Hello World";
        Integer var2 = 34;
        String[] var3 = {"one", "two"};
        Person var4 = new Person("Jake", "Smith", 30);
        Person var5 = new Person("Abe", "Lincoln", 56);
        Object obj = var1;

        if(obj instanceof String) {
            String msg = (String) obj;
            System.out.println(msg.toUpperCase());
        }

        switch(obj) {
            case null -> System.out.println("It's null");
            case String msg -> System.out.println(msg);
            case Integer num -> System.out.println("Your number is " + num);
            case String[] arr -> System.out.println("Looks like an array with %d elements"
                    .formatted(arr.length));
            case Person p when p.firstName().length() > 3 -> System.out.println("Looks like " +
                    p.firstName());
            default -> System.out.println("Have no idea");
        }


    }
}
