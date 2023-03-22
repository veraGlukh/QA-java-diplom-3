package ru.yandex.practicum.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.practicum.burgers.pages.*;

public class EntranceTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    // Тест 1: Вход по кнопке Войти в аккаунт на главной;

    @Test
    @DisplayName("Check login from main page with enter account button") // имя теста
    @Description("Basic test for login with valid credentials")
    public void checkEntranceWithEnterAccountButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new MainPage(driver)
                .openMainPage()
                .clickEnterAccountButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new PersonalAccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК:", isProfileButtonDisplayed);
    }

    // Тест 2: Вход через кнопку Личный кабинет;

    @Test
    @DisplayName("Check login from main page with personal account button") // имя теста
    @Description("Basic test for login with valid credentials")
    public void checkEntranceWithPersonalAccountButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new MainPage(driver)
                .openMainPage()
                .clickPersonalAccountButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new PersonalAccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК:", isProfileButtonDisplayed);
    }

    // Тест 3: Вход через кнопку в форме регистрации;

    @Test
    @DisplayName("Check login from registration page") // имя теста
    @Description("Basic test for login with valid credentials")
    public void checkEntranceWithEnterRegistrationPageButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton()
                .openRegistrationPage()
                .clickEnterButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new PersonalAccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК:", isProfileButtonDisplayed);
    }

    // Тест 4: Вход через кнопку в форме восстановления пароля.

    @Test
    @DisplayName("Check login from forgot password page") // имя теста
    @Description("Basic test for login with valid credentials")
    public void checkEntranceWithEnterForgotPasswordPageButton() {

        registrationTestData = RegistrationTestDataGenerator.getValidData();

        new RegistrationPage(driver)
                .openRegistrationPage()
                .setName(registrationTestData.name)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickRegistrationButton();
        new ForgotPasswordPage(driver)
                .openForgotPasswordPage()
                .clickEnterButton();
        new LoginPage(driver)
                .setEmail(registrationTestData.email)
                .setPassword(registrationTestData.password)
                .clickEnterButton();
        new MainPage(driver)
                .clickPersonalAccountButton();

        boolean isProfileButtonDisplayed = new PersonalAccountPage(driver).isProfileButtonDisplayed();
        Assert.assertTrue("Не произошел переход в ЛК:", isProfileButtonDisplayed);
    }
}
