package ru.yandex.practicum.burgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    // Локатор поля Email
    private By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // Локатор поля Пароль
    private By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // Локатор кнопки Войти
    private By enterButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    // Локатор надписи Вход
    private By enterTitle = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    // Конструктор класса
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод перехода на страницу Входа в личный кабинет
    public LoginPage openLoginPage() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        return this;
    }

    // Метод заполнения поля Email
    public LoginPage setEmail(String email) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    // Метод заполнения поля Password
    public LoginPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    // Метод клика по кнопке Войти
    public LoginPage clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }

    // Метод проверки отображения надписи вход

    public boolean isEnterTitleDisplayed() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(enterTitle).isDisplayed();
    }

}
