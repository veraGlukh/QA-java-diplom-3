package ru.yandex.practicum.burgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    // Метод перехода на страницу восстановления пароля
    public ForgotPasswordPage openForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        return this;
    }

    // Локатор кнопки Войти
    private By enterButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    // Конструктор класса
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод клика по кнопке Войти
    public ForgotPasswordPage clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }
}
