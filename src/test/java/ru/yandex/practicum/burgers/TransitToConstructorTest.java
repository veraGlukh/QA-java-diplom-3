package ru.yandex.practicum.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.practicum.burgers.pages.*;

public class TransitToConstructorTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    // Тест 1: Переход из личного кабинета в конструктор по клику на кнопку Конструктор

    @Test
    @DisplayName("Check transit from personal account page to the main page") // имя теста
    @Description("Basic test for transit with constructor button")
    public void checkTransitWithConstructorButton() {

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
        new PersonalAccountPage(driver)
                .clickConstructorButton();

        boolean isSetBuggerTitleDisplayed = new MainPage(driver).isSetBuggerTitleDisplayed();
        Assert.assertTrue("Не произошел переход в Конструктор:", isSetBuggerTitleDisplayed);
    }

    // Тест 2: Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers

    @Test
    @DisplayName("Check transit from personal account page to the main page") // имя теста
    @Description("Basic test for transit with logo Stellar Burgers")
    public void checkTransitWithLogoStellarBurgers() {

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
        new PersonalAccountPage(driver)
                .clickLogoStellarBurgers();

        boolean isSetBuggerTitleDisplayed = new MainPage(driver).isSetBuggerTitleDisplayed();
        Assert.assertTrue("Не произошел переход в Конструктор:", isSetBuggerTitleDisplayed);
    }
}

