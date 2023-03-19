package ru.yandex.practicum.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.practicum.burgers.pages.*;

public class RegistrationTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    // Тест 1: Успешная регистрация;

    @Test
    @DisplayName("Check registration") // имя теста
    @Description("Basic test for registration with valid user data")
    public void checkRegistrationWithValidData() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new LoginPage(driver)
                .openLoginPage()
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new PersonalAccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК:", isProfileButtonDisplayed);
    }

    // Тест 2: Ошибка для некорректного пароля — 5 символов. Минимальный пароль — шесть символов.

    @Test
    @DisplayName("Check registration") // имя теста
    @Description("Negative test for registration with invalid user password")
    public void checkRegistrationWithInvalidShortPassword() {
        registrationTestData = RegistrationTestDataGenerator.getInvalidDataWithShortPassword();

        boolean isIncorrectPasswordTitleDisplayed =
                new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton()
                .isIncorrectPasswordTitleDisplayed();

        Assert.assertTrue("Не отображается надпись Некорректный пароль:", isIncorrectPasswordTitleDisplayed);
    }

}
