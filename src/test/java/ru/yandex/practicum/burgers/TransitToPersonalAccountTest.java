package ru.yandex.practicum.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.practicum.burgers.pages.*;

public class TransitToPersonalAccountTest extends BaseTest {

    private RegistrationTestData registrationTestData;

    // Тест 1: Переход по клику на «Личный кабинет».

    @Test
    @DisplayName("Check transit from the main page to personal account page") // имя теста
    @Description("Basic test for transit with personal account button")
    public void checkTransitWithPersonalAccountButton() {

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
}
