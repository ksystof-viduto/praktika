package lt.vtmc.utils;

import java.util.Random;

public class DataGenerator {

    public static String getRandomEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "user" + randomInt + "@email.com";
    }
}
