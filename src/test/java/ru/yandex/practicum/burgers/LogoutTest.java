package ru.yandex.practicum.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.practicum.burgers.pages.*;

public class LogoutTest extends BaseTest {
    private RegistrationTestData registrationTestData;

    // Тест 1: Выход по кнопке Выйти в личном кабинете

    @Test
    @DisplayName("Check logout") // имя теста
    @Description("Basic test for logout from account page")
    public void checkLogout() {

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
                .clickLogoutButton();

        boolean isEnterTitleDisplayed = new LoginPage(driver).isEnterTitleDisplayed();
        Assert.assertTrue("Выход не произошел:", isEnterTitleDisplayed);
    }
}
