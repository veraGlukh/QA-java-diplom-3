package ru.yandex.practicum.burgers;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class RegistrationTestDataGenerator {

    static int baseLength = 8;
    static int shortPasswordLength = 5;
    static boolean useLetters = true;
    static boolean useNumbers = true;

    public static RegistrationTestData getValidData() {

        String randomName = RandomStringUtils.random(baseLength, useLetters, useNumbers);
        String randomEmail = RandomStringUtils.random(baseLength, useLetters, useNumbers) + "@" +
                RandomStringUtils.random(baseLength, useLetters, useNumbers) + "." +
                RandomStringUtils.random(baseLength, useLetters, useNumbers);
        String randomPassword = RandomStringUtils.random(baseLength, useLetters, useNumbers);

        return new RegistrationTestData(randomName, randomEmail, randomPassword);
    }

    public static RegistrationTestData getInvalidDataWithShortPassword() {

        String randomName = RandomStringUtils.random(baseLength, useLetters, useNumbers);
        String randomEmail = RandomStringUtils.random(baseLength, useLetters, useNumbers) + "@" +
                RandomStringUtils.random(baseLength, useLetters, useNumbers) + "." +
                RandomStringUtils.random(baseLength, useLetters, useNumbers);
        String randomPassword = RandomStringUtils.random(shortPasswordLength, useLetters, useNumbers);

        return new RegistrationTestData(randomName, randomEmail, randomPassword);
    }
}
