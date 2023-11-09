package com.github.manu156.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface CommonUtil {
    static Random random = new Random();
    static String chars = "abcdefghijklmnopqrstuvwxyz ";
    public static void sleep(long timeInMs) {
        try {
            Thread.sleep(timeInMs);
        } catch (Exception ignored) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepRandom() {
        try {
            Thread.sleep(random.nextInt(200));
        } catch (Exception ignored) {
            Thread.currentThread().interrupt();
        }
    }

    public static List<String> getRandomListOfStrings(List<String> input) {
        sleepRandom();
        List<String> result = new ArrayList<>();
        int limit = random.nextInt(5);
        for (int i=0; i<limit; i++) {
            int stringSize = random.nextInt(10);
            StringBuilder tempString = new StringBuilder();
            while (tempString.length() < stringSize) {
                int index = random.nextInt(chars.length());
                tempString.append(chars.charAt(index));
            }
            result.add(tempString.toString());
        }

        if (input.size() > 1) {
            result.add(input.get(0));
        }

        return result;
    }
}
