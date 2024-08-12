import java.util.Random;

public class FunctionJava {
    public static void main(String[] args) {
        System.out.println(generateRandomEmail());
    }

    public static String generateRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        int length = 10; // Length of the email prefix
        String domain = "gmail.com"; // You can change the domain

        for (int i = 0; i < length; i++) {
            email.append(chars.charAt(random.nextInt(chars.length())));
        }

        return email.toString() + "@" + domain;
    }
}
